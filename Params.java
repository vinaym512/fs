package com.fs.app.automation.Misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

    public class Params {
        private static final Logger LOG = LoggerFactory.getLogger(Params.class);
        public static String PLATFORM;
        static {
            LOG.info("Loading file properties...");
            PLATFORM = Props.getProp("platform");
        }
        /*public static String getPlatform(){
            String abc =  Props.getProp("platform");
            return abc;
        }*/
    }
