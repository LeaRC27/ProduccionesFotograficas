/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.sise;

import java.util.HashMap;
import java.util.Map;
import org.apache.tiles.Attribute;
import org.apache.tiles.Definition;
import org.apache.tiles.definition.DefinitionsFactory;
import org.apache.tiles.request.Request;
/**
 *
 * @author LeaRC
 */
public class TilesDefinitionsConfig implements DefinitionsFactory {

            private static final Map<String, Definition> tilesDefinitions = new HashMap<String,Definition>();
            private static final Attribute BASE_TEMPLATE = new Attribute("/WEB-INF/views/defaultLayout.jsp");
            
            @Override
            public Definition getDefinition(String name, Request tilesContext) {
                return tilesDefinitions.get(name);
            }

            /**
             * @param name <code>Name of the view</code>
             * @param title <code>Page title</code>
             * @param body <code>Body JSP file path</code>
             *
             * <code>Adds default layout definitions</code>
             */
            
            private static void addDefaultLayoutDef(String name, String title, String body) {
                Map<String, Attribute> attributes = new HashMap<String,Attribute>();

                attributes.put("title", new Attribute(title));
                attributes.put("header", new Attribute("/WEB-INF/views/defaultHeader.jsp"));
                attributes.put("menu", new Attribute("/WEB-INF/views/defaultMenu.jsp"));
                attributes.put("body", new Attribute(body));
                attributes.put("footer", new Attribute("/WEB-INF/views/defaultFooter.jsp"));

                tilesDefinitions.put(name, new Definition(name, BASE_TEMPLATE, attributes));
            }

            /**
             * <code>Add Apache tiles definitions</code>
             */
            public static void addDefinitions(){
                
                addDefaultLayoutDef("admin", "Welcome ADMIN", "/admin.jsp");
                addDefaultLayoutDef("home", "Welcome", "/WEB-INF/views/home.jsp");
		addDefaultLayoutDef("products", "Products", "/WEB-INF/views/products.jsp");
		addDefaultLayoutDef("contactus", "Contact Us", "/WEB-INF/views/contactus.jsp");
                
                addDefaultLayoutDef("album", "Album", "/WEB-INF/views/album.jsp");
                addDefaultLayoutDef("login", "Login", "/WEB-INF/views/login.jsp");
                addDefaultLayoutDef("register", "Register", "/WEB-INF/views/register.jsp");
                addDefaultLayoutDef("403", "Access Denied", "/403.jsp");
                addDefaultLayoutDef("itemmenu", "Sitio en construccion", "/WEB-INF/views/itemmenu.jsp");

            }

    
        }
