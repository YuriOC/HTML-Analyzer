import java.util.Stack;

public class HtmlLineProcessor {
    private int level = 0;
    private int maxLevel = -1;
    private String text = null;
    Stack<String> tags = new Stack<>();
    boolean error = false;

    public void ReadHTMLContentLines(String line){

        line = line.trim();
        if (line.isEmpty()){
            return;
        }

        if(line.startsWith("<") && !line.startsWith("</")){
            level++;
            tags.push(line.substring(1, line.length() - 1));
        } else if (line.startsWith("</")) {
            level--;
            if(line.substring(2, line.length() - 1).equals(tags.lastElement())){
                tags.pop();
            } else {
                error = true;
            }
        } else {
            if (level > maxLevel){
                maxLevel = level;
                text = line;
            }
        }
    }

    public String getText() {
        if(!error) {
            return text;
        } else {
            return "malformed HTML";
        }
    }
}
