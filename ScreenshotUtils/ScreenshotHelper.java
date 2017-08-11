package com.fs.app.automation.ScreenshotUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class ScreenshotHelper {


    private static final ThreadLocal<Map<String, Object>> SCREEN_SHOTS = new ThreadLocal<Map<String, Object>>() {
        @Override
        protected Map<String, Object> initialValue() {
            return new HashMap<>();
        }
    };

    public static void add(String name, byte[] image) {
        SCREEN_SHOTS.get().put(name, image.clone());
    }

    public static Map<String, Object> getScreenShotsForCurrentTest() {
        return SCREEN_SHOTS.get();
    }

    public static void tidyUpAfterTestRun() {
        SCREEN_SHOTS.remove();
    }

    public static byte[] imageToByteArray(BufferedImage image) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            ImageIO.write(image, "png", stream);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        return stream.toByteArray();
    }
}
