package at.aumand.stackoverflow.question30646707;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.oxm.MediaType;
import org.junit.Test;

public class JsonTest {
	private static final String EXPECTED_OUTPUT = "{\"testVar\":\"testValue\"}";

	@Test
	public void shouldMarshalObjectElementToExpectedOutput()
			throws JAXBException {
		// given
		ObjectElement objElement = new ObjectElement();
		Marshaller marshaller = aMarshaller();
		StringWriter sw = new StringWriter();

		// when
		marshaller.marshal(objElement, sw);

		// then
		assertEquals(EXPECTED_OUTPUT, sw.toString());
	}

	@Test
	public void shouldMarshalStringElementToExpectedOutput()
			throws JAXBException {
		// given
		StringElement objElement = new StringElement();
		Marshaller marshaller = aMarshaller();
		StringWriter sw = new StringWriter();

		// when
		marshaller.marshal(objElement, sw);

		// then
		assertEquals(EXPECTED_OUTPUT, sw.toString());
	}

	private Marshaller aMarshaller() throws JAXBException {
		JAXBContext jc = JAXBContextFactory.createContext(new Class[] {
				ObjectElement.class, StringElement.class }, null);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE,
				MediaType.APPLICATION_JSON);

		return marshaller;
	}
}
