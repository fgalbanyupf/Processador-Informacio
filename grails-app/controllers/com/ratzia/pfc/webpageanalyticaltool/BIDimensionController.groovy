package com.ratzia.pfc.webpageanalyticaltool

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
@Transactional(readOnly = true)
class BIDimensionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond BIDimension.list(params), model:[BIDimensionInstanceCount: BIDimension.count()]
    }

    def show(BIDimension BIDimensionInstance) {
        respond BIDimensionInstance
    }

    def create() {
        respond new BIDimension(params)
    }

    @Transactional
    def save(BIDimension BIDimensionInstance) {
        if (BIDimensionInstance == null) {
            notFound()
            return
        }

        if (BIDimensionInstance.hasErrors()) {
            respond BIDimensionInstance.errors, view:'create'
            return
        }

        BIDimensionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'BIDimensionInstance.label', default: 'BIDimension'), BIDimensionInstance.id])
                redirect BIDimensionInstance
            }
            '*' { respond BIDimensionInstance, [status: CREATED] }
        }
    }

    def edit(BIDimension BIDimensionInstance) {
        respond BIDimensionInstance
    }

    @Transactional
    def update(BIDimension BIDimensionInstance) {
        if (BIDimensionInstance == null) {
            notFound()
            return
        }

        if (BIDimensionInstance.hasErrors()) {
            respond BIDimensionInstance.errors, view:'edit'
            return
        }

        BIDimensionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'BIDimension.label', default: 'BIDimension'), BIDimensionInstance.id])
                redirect BIDimensionInstance
            }
            '*'{ respond BIDimensionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(BIDimension BIDimensionInstance) {

        if (BIDimensionInstance == null) {
            notFound()
            return
        }

        BIDimensionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'BIDimension.label', default: 'BIDimension'), BIDimensionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }
    
    @Transactional
    def fieldUp(BIDimension BIDimensionInstance) {
        DBField DBFieldInstance = DBField.get(params.fieldId)
        if (BIDimensionInstance == null) {
            notFound()
            return
        }
        if (DBFieldInstance == null) {
            notFound()
            return
        }
        BIDimensionInstance.fieldUp(DBFieldInstance)
        BIDimensionInstance.save flush:true

        respond BIDimensionInstance, view:"show"
    }
    
    @Transactional
    def fieldDown(BIDimension BIDimensionInstance) {
        DBField DBFieldInstance = DBField.get(params.fieldId)
        if (BIDimensionInstance == null) {
            notFound()
            return
        }
        
        if (DBFieldInstance == null) {
            notFound()
            return
        }

        BIDimensionInstance.fieldDown(DBFieldInstance)
        BIDimensionInstance.save flush:true

        respond BIDimensionInstance, view:"show"
    }
    
    @Transactional
    def removeField(BIDimension BIDimensionInstance) {
        DBField DBFieldInstance = DBField.get(params.fieldId)
        if (BIDimensionInstance == null) {
            notFound()
            return
        }
        
        if (DBFieldInstance == null) {
            notFound()
            return
        }

        BIDimensionInstance.removeFromFields(DBFieldInstance)
        BIDimensionInstance.save flush:true

        respond BIDimensionInstance, view:"show"
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'BIDimensionInstance.label', default: 'BIDimension'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
