
package se.miun.swot.electrosocket.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "test", namespace = "http://electrosocket.swot.miun.se/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "test", namespace = "http://electrosocket.swot.miun.se/")
public class Test {

    @XmlElement(name = "input", namespace = "")
    private String input;

    /**
     * 
     * @return
     *     returns String
     */
    public String getInput() {
        return this.input;
    }

    /**
     * 
     * @param input
     *     the value for the input property
     */
    public void setInput(String input) {
        this.input = input;
    }

}
