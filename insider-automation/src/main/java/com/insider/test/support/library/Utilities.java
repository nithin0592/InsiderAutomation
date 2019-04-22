package com.insider.test.support.library;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * contains Utilities
 */

public final class Utilities {

    /**
     * boolean isMac()
     * <p>
     * Checks if the system is a Macintosh machine.
     * <p>
     * The method retrieves the operating system name from the system, compares
     * the name to "mac", and returns the comparison result.
     * 
     * @return {@link boolean} - result of the mac test
     * @throws Exception
     */
    public static boolean isMac() throws Exception {

        String os = System.getProperty("os.name").toLowerCase();
        // Mac
        return (os.indexOf("mac") >= 0);

    }

    /**
     * boolean isWindows()
     * <p>
     * Checks if the system is a Windows machine.
     * <p>
     * The method retrieves the operating system name from the system, compares
     * the name to "win", and returns the comparison result.
     *
     * @return {@link boolean} - result of the win test
     * @throws Exception
     */
    public static boolean isWindows() throws Exception {

        String os = System.getProperty("os.name").toLowerCase();
        // windows
        return ((os.indexOf("win") >= 0) || (os.indexOf("Win") >= 0));

    }

    /**
     * boolean isUnix()
     * <p>
     * Checks if the system is a Unix machine.
     * <p>
     * The method retrieves the operating system name from the system, compares
     * the name to "nix"/"nux", and returns the comparison result.
     * 
     * @return {@link boolean} - result of the unix test
     * @throws Exception
     */
    public static boolean isUnix() throws Exception {

        String os = System.getProperty("os.name").toLowerCase();
        // linux or unix
        return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);

    }

    /**
     * isValidJson(String json)
     * <p>
     * Checks if a some text is valid JSON.
     * <p>
     * 
     * @return {@link boolean} - result of the check
     */
    public static boolean isValidJson(String json) {
        try {
            new JsonParser().parse(json);
            return true;
        } catch (JsonSyntaxException jse) {
            return false;
        }
    }
}
