package com.ratzia.pfc.webpageanalyticaltool



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.custommonkey.xmlunit.*
import groovy.xml.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
@Transactional(readOnly = true)
class BISchemaTemplateController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    def grailsApplication
    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond BISchemaTemplate.list(params), model:[BISchemaTemplateInstanceCount: BISchemaTemplate.count()]
    }

    def show(BISchemaTemplate BISchemaTemplateInstance) {
        respond BISchemaTemplateInstance
    }

    def create() {
        respond new BISchemaTemplate(params)
    }

    @Transactional
    def save(BISchemaTemplate BISchemaTemplateInstance) {
        if (BISchemaTemplateInstance == null) {
            notFound()
            return
        }

        if (BISchemaTemplateInstance.hasErrors()) {
            respond BISchemaTemplateInstance.errors, view:'create'
            return
        }

        //Append code
        generateCode(BISchemaTemplateInstance)
        
        BISchemaTemplateInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'BISchemaTemplateInstance.label', default: 'BISchemaTemplate'), BISchemaTemplateInstance.id])
                redirect BISchemaTemplateInstance
            }
            '*' { respond BISchemaTemplateInstance, [status: CREATED] }
        }
    }

    def edit(BISchemaTemplate BISchemaTemplateInstance) {
        respond BISchemaTemplateInstance
    }

    @Transactional
    def update(BISchemaTemplate BISchemaTemplateInstance) {
        if (BISchemaTemplateInstance == null) {
            notFound()
            return
        }

        if (BISchemaTemplateInstance.hasErrors()) {
            respond BISchemaTemplateInstance.errors, view:'edit'
            return
        }
        
        
        //Append code
        generateCode(BISchemaTemplateInstance)
        BISchemaTemplateInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'BISchemaTemplate.label', default: 'BISchemaTemplate'), BISchemaTemplateInstance.id])
                redirect BISchemaTemplateInstance
            }
            '*'{ respond BISchemaTemplateInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(BISchemaTemplate BISchemaTemplateInstance) {

        if (BISchemaTemplateInstance == null) {
            notFound()
            return
        }

        BISchemaTemplateInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'BISchemaTemplate.label', default: 'BISchemaTemplate'), BISchemaTemplateInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'BISchemaTemplateInstance.label', default: 'BISchemaTemplate'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    def cube(BISchemaTemplate BISchemaTemplateInstance) {
         /*
          * XXX: BIDimension must be refactored to include fields order and properties <frans>
        def biDimensions = BIDimension.findAll()
        
        def templateXML = new XmlSlurper().parseText(BISchemaTemplateInstance.code)
       
        //Dimensions
        templateXML.appendNode{
            for(dimension in BIDimension.findAll()){
                Dimension(name:dimension.name){
                    Hierarchy(hasAll:"true", primaryKey:"id"){
                        Table(name:"page_fields")
                        for(DBField dbField in dimension.fields){
                            Level(name:dbField.descriptiveName, column:dbField.fieldName,uniqueMembers:"false")
                        }
                    }
                }
            }
        }
        
        templateXML.Cube.each{
            it.appendNode{
               //Dimension usage
               for(dimension in BIDimension.findAll()){
                    DimensionUsage(name:dimension.name,source:dimension.name,foreignKey:"id")
               }
               
               //Dimensions for each collectionable field
               for(dbField in DBField.findAllIsCollection(true)){
                   Dimension(type:"StandardDimension",visible:"true",foreignKey:"id",highCardinality:"false",name:dbField.descriptiveName){
                       Hierarchy(name:"Hierarchy " + dbField.descriptiveName, visible:"true", hasAll:"true", primaryKey:"id",primaryKeyTable:dbField.fieldName + "_table"){
                           Table(name:dbField.fieldName + "_table"){}
                           //Falta type, en principi és opcional...
                           Level(name:dbField.descriptiveName, visible:"true", column:dbField.fieldName, uniqueMembers:"false",levelType:"Regular", hideMemberIf:"Never")
                       }
                   }
               }
               
                //Measures
                for(biMeasure in BIMeasure.findAll()){
                    Measure(name:biMeasure.name, column:biMeasure.field.fieldName, aggregator:biMeasure.aggregator, visible:biMeasure.visible)
                }
            }
        }        
        
        //Convert to text
        def xmlText = new StreamingMarkupBuilder().bind {
            mkp.yield templateXML
        }.toString()
        
        //Reorder cubes
        XmlParser parser = new XmlParser()
        def root = parser.parseText(xmlText)
        NodeList cubeNodes = root.Cube
        for(Node node in cubeNodes){
            root.remove(node)
            root.append(node)
        }
        def writer = new StringWriter()
        new XmlNodePrinter(new PrintWriter(writer)).print(root)
        xmlText = writer.toString()

        BISchemaTemplateInstance.generatedCode = xmlText// XmlUtil.serialize(xmlText)
        
        */
        /* XXX: Once above code and BIDimensions are fixed this shoud be removed*/
        //BISchemaTemplateInstance.generatedCode = BISchemaTemplateInstance.code
        
        //Append code
        generateCode(BISchemaTemplateInstance)
        BISchemaTemplateInstance.save()
        
        /*FIXME: Validate against mondrian dtd*/
        
        //Save XML
        new File(grailsApplication.config.bisystem.cubedefinitionfile).withWriter{ it << BISchemaTemplateInstance.generatedCode } 
        
       
        
        //respond BISchemaTemplateInstance
        flash.message = message(code: 'BISchemaTemplate.savedToSaiku' )
        respond BISchemaTemplateInstance, view:'show'
    }
    
    //Generate XML code based on BIDimensions and BIMeasures
    def generateCode(BISchemaTemplate BISchemaTemplateInstance) {
        def biDimensions = BIDimension.findAll()
        
        def templateXML = new XmlSlurper().parseText(BISchemaTemplateInstance.code)
       
        //Dimensions
        templateXML.appendNode{
            for(dimension in BIDimension.findAll()){
                Dimension(name:dimension.name){
                    Hierarchy(hasAll:"true", primaryKey:"id"){
                        Table(name:"page_fields")
                        for(DBField dbField in dimension.fields){
                            Level(name:dbField.descriptiveName, column:dbField.fieldName,uniqueMembers:"false")
                        }
                    }
                }
            }
        }
        
        templateXML.Cube.each{
            it.appendNode{
               //Dimension usage
               for(dimension in BIDimension.findAll()){
                    DimensionUsage(name:dimension.name,source:dimension.name,foreignKey:"id")
               }
               
               //Dimensions for each collectionable field
               for(dbField in DBField.findAllIsCollection(true)){
                   Dimension(type:"StandardDimension",visible:"true",foreignKey:"id",highCardinality:"false",name:dbField.descriptiveName){
                       Hierarchy(name:"Hierarchy " + dbField.descriptiveName, visible:"true", hasAll:"true", primaryKey:"id",primaryKeyTable:dbField.fieldName + "_table"){
                           Table(name:dbField.fieldName + "_table"){}
                           //Falta type, en principi és opcional...
                           Level(name:dbField.descriptiveName, visible:"true", column:dbField.fieldName, uniqueMembers:"false",levelType:"Regular", hideMemberIf:"Never")
                       }
                   }
               }
               
                //Measures
                for(biMeasure in BIMeasure.findAll()){
                    Measure(name:biMeasure.name, column:biMeasure.field.fieldName, aggregator:biMeasure.aggregator, visible:biMeasure.visible)
                }
            }
        }        
        
        //Convert to text
        def xmlText = new StreamingMarkupBuilder().bind {
            mkp.yield templateXML
        }.toString()
        
        //Reorder cubes
        XmlParser parser = new XmlParser()
        def root = parser.parseText(xmlText)
        NodeList cubeNodes = root.Cube
        for(Node node in cubeNodes){
            root.remove(node)
            root.append(node)
        }
        def writer = new StringWriter()
        new XmlNodePrinter(new PrintWriter(writer)).print(root)
        xmlText = writer.toString()

        BISchemaTemplateInstance.generatedCode = xmlText// XmlUtil.serialize(xmlText) 
    }
    
    
    @Transactional
    def datawarehouseCreator(BISchemaTemplate BISchemaTemplateInstance) {
        // If it was stopped... locking is taken care by the versioning system on Hibernate
        BackgroundProcess backgroundProcess = BackgroundProcess.findByBackgroundProcessType(BackgroundProcessType.DATAWAREHOUSE_CREATOR)
        if(backgroundProcess.status == BackgroundProcessStatus.STOPPED){
            backgroundProcess.status = BackgroundProcessStatus.IDLE
            backgroundProcess.save(true)
            
        }
        DatawarehouseCreatorJob.schedule(new Date(),[:])
        flash.message = message(code: 'BISchemaTemplate.creatingDWContent' )
        respond BISchemaTemplateInstance, view:'show'
    }
}
