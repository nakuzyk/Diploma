import lombok.AllArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public enum AirplaneColor {

    BLACK("#000", 70){
        @Override
        public void burnoutColor() {
            BLACK.sunBurnoutPercentage = 5 * BLACK.sunBurnoutPercentage;
        }
    },
    WHITE("#ffffff", 50){
        @Override
        public void burnoutColor() {
            WHITE.sunBurnoutPercentage = 2 * WHITE.sunBurnoutPercentage;
        }
    };

    private String colorRGB;
    private int sunBurnoutPercentage;

    public abstract void burnoutColor();

    public static boolean validateRGB(String colorRGB) {
        Pattern colorPattern = Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$");
        Matcher m = colorPattern.matcher(colorRGB);
        return m.matches();
    }
}