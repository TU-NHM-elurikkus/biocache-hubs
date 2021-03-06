<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>

<html>
    <head>
        <meta name="layout" content="${grailsApplication.config.skin.layout}" />

        <title>
            Admin Functions | ${grailsApplication.config.skin.orgNameLong}
        </title>

        <asset:stylesheet src="admin.css" />
    </head>

    <body>
        <div class="row-fluid">
            <div class="span12">
                <div id="breadcrumb">
                    <ol class="breadcrumb">
                        <li>
                            <a href="${g.createLink(uri:"/")}">
                                Home
                            </a>
                            <span class="icon icon-arrow-right"></span>
                        </li>
                        <li class="active">
                            Admin
                        </li>
                    </ol>
                </div>

                <h1>Admin Functions</h1>

                <g:if test="${flash.message}">
                    <div class="message alert alert-info">
                        <button type="button" class="close" onclick="$(this).parent().hide()">
                            ×
                        </button>
                        <b>Alert:</b> ${raw(flash.message)}
                    </div>
                </g:if>

                <h2>Cache management</h2>
                <div class="btn-group">
                    <a href="${g.createLink(action:'clearAllCaches')}" class="btn btn-primary ">
                        Clear all caches
                    </a>
                    <a href="${g.createLink(action:'clearCollectoryCache')}" class="btn">
                        Clear collectory cache
                    </a>
                    <a href="${g.createLink(action:'clearFacetsCache')}" class="btn">
                        Clear facets cache
                    </a>
                    <a href="${g.createLink(action:'clearLongTermCache')}" class="btn">
                        Clear long term cache
                    </a>
                    <a href="${g.createLink(action:'clearPropertiesCache')}" class="btn">
                        Clear i18n messages cache
                    </a>
                </div>

                <div id="alaAdmin">
                    <hr />
                    <g:render template="/ala-admin-form" plugin="ala-admin-plugin" />
                </div>
            </div>
        </div>

    </body>
</html>
