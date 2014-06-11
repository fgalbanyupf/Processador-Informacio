package com.ratzia.pfc.webpageanalyticaltool



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
@Transactional(readOnly = true)
class BIMeasureController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond BIMeasure.list(params), model:[BIMeasureInstanceCount: BIMeasure.count()]
    }

    def show(BIMeasure BIMeasureInstance) {
        respond BIMeasureInstance
    }

    def create() {
        respond new BIMeasure(params)
    }

    @Transactional
    def save(BIMeasure BIMeasureInstance) {
        if (BIMeasureInstance == null) {
            notFound()
            return
        }

        if (BIMeasureInstance.hasErrors()) {
            respond BIMeasureInstance.errors, view:'create'
            return
        }

        BIMeasureInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'BIMeasureInstance.label', default: 'BIMeasure'), BIMeasureInstance.id])
                redirect BIMeasureInstance
            }
            '*' { respond BIMeasureInstance, [status: CREATED] }
        }
    }

    def edit(BIMeasure BIMeasureInstance) {
        respond BIMeasureInstance
    }

    @Transactional
    def update(BIMeasure BIMeasureInstance) {
        if (BIMeasureInstance == null) {
            notFound()
            return
        }

        if (BIMeasureInstance.hasErrors()) {
            respond BIMeasureInstance.errors, view:'edit'
            return
        }

        BIMeasureInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'BIMeasure.label', default: 'BIMeasure'), BIMeasureInstance.id])
                redirect BIMeasureInstance
            }
            '*'{ respond BIMeasureInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(BIMeasure BIMeasureInstance) {

        if (BIMeasureInstance == null) {
            notFound()
            return
        }

        BIMeasureInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'BIMeasure.label', default: 'BIMeasure'), BIMeasureInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'BIMeasureInstance.label', default: 'BIMeasure'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
