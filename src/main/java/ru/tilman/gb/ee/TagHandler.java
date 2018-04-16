package ru.tilman.gb.ee;

import javax.inject.Inject;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TagHandler extends TagSupport {

    //это атрибут, который задан в *.ltd и вставлен в  jsp. Пока непонятно, что с ним делать, видимо передавать значение и обрабатывать
    private String basic;

    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        try {
            writer.println("Этот тэг создан мною. Для примера как на вебинаре выведу время " +
                    new SimpleDateFormat("HH:mm").format(new Date()));
            writer.println("<br>");
            writer.println("А вот что содержиться в атрибуте basic на jsp странице: " + basic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }
}
