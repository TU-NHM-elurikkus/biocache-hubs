/*
 * Copyright (C) 2014 Atlas of Living Australia
 * All Rights Reserved.
 *
 * The contents of this file are subject to the Mozilla Public
 * License Version 1.1 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of
 * the License at http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS
 * IS" basis, WITHOUT WARRANTY OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * rights and limitations under the License.
 */

package au.org.ala.biocache.hubs

/**
 * Admin functions - should be protected by login and ROLE_ADMIN or equiv.
 */
class AdminController {
    def scaffold = true
    def facetsCacheService, webServicesService
    def messageSourceCacheService

    def index() {
        // [ message: "not used" ]
    }

    def clearAllCaches() {
        def message = doClearAllCaches()
        flash.message = message.replaceAll("\n","<br/>")
        redirect(action:'index')
    }

    private String doClearAllCaches() {
        def message = "Clearing all caches...\n"
        message += webServicesService.doClearCollectoryCache()
        message += webServicesService.doClearLongTermCache()
        message += doClearFacetsCache()
        message += doClearPropertiesCache()
        message
    }

    def clearCollectoryCache() {
        flash.message = webServicesService.doClearCollectoryCache()
        redirect(action:'index')
    }

    def clearLongTermCache() {
        flash.message = webServicesService.doClearLongTermCache()
        redirect(action:'index')
    }

    def clearFacetsCache() {
        flash.message = doClearFacetsCache()
        redirect(action:'index')
    }

    def clearPropertiesCache() {
        flash.message = doClearPropertiesCache()
        redirect(action:'index')
    }

    def doClearFacetsCache() {
        facetsCacheService.clearCache()
        "facetsCache cache cleared\n"
    }

    def doClearPropertiesCache() {
        messageSourceCacheService.clearMessageCache()
        "i18n messages cache cleared\n"
    }

}
