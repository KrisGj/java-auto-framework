package framework.driver;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum BrowserType {

    FIREFOX("Firefox"),
    CHROME("Chrome");

    private final String name;

    /**
     * Gets an enum representation of this String value browser type. String value is case-insensitive.
     *
     * @param type String representation of browser type, for example "chrome"
     * @return enum representation of browser type, for example CHROME
     */
    public static BrowserType fromValue(String type) {

        return Arrays.stream(BrowserType.values())
                .filter(browserType -> browserType.getName().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown browser type: " + type));
    }
}
