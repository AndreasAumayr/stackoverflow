package at.aumand.stackoverflow.question30646707;

import javax.xml.bind.annotation.XmlElement;

public class ObjectElement {
	@XmlElement(type = String.class)
	public Object testVar = "testValue";
}