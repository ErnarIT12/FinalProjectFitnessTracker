package fitnesstracker.bridge.implementor;

public class HtmlFormat extends FileFormat {

    public HtmlFormat() {
        super("report.html");
    }

    @Override
    public void renderTitle(String title) {
        content.append("<html><body>\n<h1>").append(title).append("</h1>\n<table border=\"1\">\n");
    }

    @Override
    public void renderLine(String key, String value) {
        content.append("<tr><td>").append(key).append("</td><td>").append(value).append("</td></tr>\n");
    }

    @Override
    public void finish() {
        content.append("</table>\n</body></html>\n");
        super.finish();
    }
}
