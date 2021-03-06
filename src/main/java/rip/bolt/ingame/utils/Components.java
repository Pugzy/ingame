package rip.bolt.ingame.utils;

import static tc.oc.pgm.lib.net.kyori.adventure.text.Component.text;

import tc.oc.pgm.lib.net.kyori.adventure.text.Component;
import tc.oc.pgm.lib.net.kyori.adventure.text.event.ClickEvent;
import tc.oc.pgm.lib.net.kyori.adventure.text.format.NamedTextColor;
import tc.oc.pgm.lib.net.kyori.adventure.text.format.Style;
import tc.oc.pgm.lib.net.kyori.adventure.text.format.TextColor;

public class Components {

  private static final String MATCH_ICON = "\u29bf";

  public static Component command(Style style, String command, String... args) {
    StringBuilder builder = new StringBuilder();

    if (!command.startsWith("/")) builder.append("/");
    builder.append(command);
    for (String arg : args) builder.append(" ").append(Components.toArgument(arg));
    command = builder.toString();

    return Component.text(command, style)
        .clickEvent(ClickEvent.clickEvent(ClickEvent.Action.RUN_COMMAND, command))
        .hoverEvent(
            Component.text("Click to run ", NamedTextColor.GREEN)
                .append(Component.text(command, style)));
  }

  static String toArgument(String input) {
    if (input == null) return null;
    return input.replace(" ", "┈");
  }

  public static Component matchResult(TextColor color) {
    return text(MATCH_ICON, color);
  }
}
