package com.ratzia.pfc.webpageanalyticaltool



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

import grails.plugin.springsecurity.annotation.Secured

@Secured(['IS_AUTHENTICATED_FULLY'])
@Transactional(readOnly = true)
class DBFieldController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DBField.list(params), model:[DBFieldInstanceCount: DBField.count()]
    }

    def show(DBField DBFieldInstance) {
        respond DBFieldInstance
    }

    def create() {
        respond new DBField(params)
    }

    @Transactional
    def save(DBField DBFieldInstance) {
        if (DBFieldInstance == null) {
            notFound()
            return
        }

        if (DBFieldInstance.hasErrors()) {
            respond DBFieldInstance.errors, view:'create'
            return
        }

        DBFieldInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'DBFieldInstance.label', default: 'DBField'), DBFieldInstance.id])
                redirect DBFieldInstance
            }
            '*' { respond DBFieldInstance, [status: CREATED] }
        }
    }

    def edit(DBField DBFieldInstance) {
        respond DBFieldInstance
    }

    @Transactional
    def update(DBField DBFieldInstance) {
        if (DBFieldInstance == null) {
            notFound()
            return
        }

        if (DBFieldInstance.hasErrors()) {
            respond DBFieldInstance.errors, view:'edit'
            return
        }

        DBFieldInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DBField.label', default: 'DBField'), DBFieldInstance.id])
                redirect DBFieldInstance
            }
            '*'{ respond DBFieldInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DBField DBFieldInstance) {

        if (DBFieldInstance == null) {
            notFound()
            return
        }

        DBFieldInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DBField.label', default: 'DBField'), DBFieldInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'DBFieldInstance.label', default: 'DBField'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
