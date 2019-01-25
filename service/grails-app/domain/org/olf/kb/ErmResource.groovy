package org.olf.kb

import org.olf.erm.Entitlement
import com.k_int.web.toolkit.refdata.RefdataValue

import grails.gorm.MultiTenant

/**
 * an ErmResource - Superclass
 * Represents a selectable resource - a package, a title in a package, a title on a platform, etc
 */
public class ErmResource implements MultiTenant<ErmResource> {
 
  String id
  String name
  
  RefdataValue type
  RefdataValue subType
  
  static hasMany = [
    entitlements: Entitlement
  ]

  static mappedBy = [
    entitlements: 'resource'
  ]
  static mapping = {
    tablePerHierarchy false
                   id generator: 'uuid', length:36
                 name column:'res_name'
                 type column:'res_type_fk'
              subType column:'res_sub_type_fk'
  }

  static constraints = {
            name (nullable:true, blank:false)
            type (nullable:true, blank:false)
         subType (nullable:true, blank:false)
  }
  
  String toString() {
    name
  }
   
}
