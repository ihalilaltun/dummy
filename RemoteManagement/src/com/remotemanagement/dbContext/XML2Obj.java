/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.remotemanagement.dbContext;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.io.BeanWriter;

/**
 *
 * @author cooper
 */
public class XML2Obj {

    public static void xmlWriterRoot(Object o, String fileName) {
        StringWriter sw = null;
        BeanWriter bw = null;
        try {
            sw = new StringWriter();
            sw.write("<?xml version='1.0' ?>\n");
            bw = new BeanWriter(sw);
            bw.getXMLIntrospector().getConfiguration()
                    .setAttributesForPrimitives(false);
            bw.getBindingConfiguration().setMapIDs(false);
            bw.enablePrettyPrint();
            bw.write(o.getClass().getName(), o);
            sw.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (bw != null) {
                    bw.close();
                }
                if (sw != null) {
                    sw.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (sw != null) {
                    sw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String epath = System.getProperty("user.dir");
//        File file = new File(epath + "/" + "conf" + "/" + fileName);
        File file = new File(epath + "/" + fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            try {
                file.createNewFile();
            } catch (IOException localIOException1) {
                e.printStackTrace();
            }
        }
        StringBuffer sb = new StringBuffer(sw.toString());
        try {
            fw.write(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Object xmlReadRoot(Object o, String fileName)
            throws Exception {
        String epath = System.getProperty("user.dir");
//        File dir = new File(epath + "/" + "conf" + "/" + fileName);
        File dir = new File(epath + "/" + fileName);
        if (dir.exists()) {
            FileInputStream fis = null;
            try {
                BeanReader br = new BeanReader();
                br.getXMLIntrospector().getConfiguration()
                        .setAttributesForPrimitives(false);
                br.getBindingConfiguration().setMapIDs(false);
                br.registerBeanClass(o.getClass().getName(), o.getClass());
                fis = new FileInputStream(dir);
                o = br.parse(fis);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return o;
    }

    public static Object xmlRead(String file) {
        Object result = null;

        XMLDecoder xmlDecoder = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            xmlDecoder = new XMLDecoder(fis);
            result = xmlDecoder.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (xmlDecoder != null) {
                xmlDecoder.close();
            }
        }
        return result;
    }

    public static void xmlWriter(Object object, String file) {
        FileOutputStream fos = null;
        XMLEncoder xmlEncoder = null;
        try {
            fos = new FileOutputStream(file);
            xmlEncoder = new XMLEncoder(fos);
            xmlEncoder.writeObject(object);
            xmlEncoder.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (xmlEncoder != null) {
                xmlEncoder.close();
            }
        }
    }

}
