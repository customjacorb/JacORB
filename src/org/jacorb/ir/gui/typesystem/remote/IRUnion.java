/*
 *        JacORB - a free Java ORB
 *
 *   Copyright (C) 1999-2011 Gerald Brose / The JacORB Team.
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Library General Public
 *   License as published by the Free Software Foundation; either
 *   version 2 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this library; if not, write to the Free
 *   Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *
 */
package org.jacorb.ir.gui.typesystem.remote;

import org.jacorb.ir.gui.typesystem.AbstractContainer;
import org.omg.CORBA.Contained;
import org.omg.CORBA.UnionDef;
import org.omg.CORBA.UnionDefHelper;
import org.omg.CORBA.UnionMember;

/**
 * This class was generated by a SmartGuide.
 * 
 */
public class IRUnion 
    extends IRNode 
    implements AbstractContainer 
{

    /**
     * IRStruct constructor comment.
     */
    protected IRUnion() {
        super();
    }
    /**
     * IRStruct constructor comment.
     * @param irObject org.omg.CORBA.IRObject
     */
    protected IRUnion(org.omg.CORBA.IRObject irObject) {
        super(irObject);
    }
    /**
     * contents method comment.
     */
    public org.jacorb.ir.gui.typesystem.ModelParticipant[] contents() 
    {
        UnionDef unionDef = 
            UnionDefHelper.narrow((org.omg.CORBA.Object)this.irObject);
        UnionMember[] members = unionDef.members();     
        Contained[] contents = unionDef.contents( org.omg.CORBA.DefinitionKind.dk_all, false);  

        org.jacorb.ir.gui.typesystem.TypeSystemNode[] result = 
            new org.jacorb.ir.gui.typesystem.TypeSystemNode[members.length + contents.length];
        for (int i=0; i<members.length; i++) {
            result[i] = RemoteTypeSystem.createTypeSystemNode(members[i]);
        } 
                for (int i = 0; i < contents.length; i++) 
        {
            result[members.length + i] = 
                                RemoteTypeSystem.createTypeSystemNode( contents[i] );
                }
        return result;  
    }
    /**
     * This method was created by a SmartGuide.
     * @return java.lang.String
     */
    public static String nodeTypeName() {
        return "union";
    }
}











