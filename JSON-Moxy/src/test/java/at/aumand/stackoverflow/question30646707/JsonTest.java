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
	private static final String EXPECTED_OUTPUT_JSON = "{\"testVar\":\"testValue\"}";
	private static final String EXPECTED_OUTPUT_XML = "<testVar>testValue</testVar>";

	@Test
	public void shouldMarshalObjectElementToExpectedJSONOutput()
			throws JAXBException {
		// given
		ObjectElement objElement = new ObjectElement();
		Marshaller marshaller = aMarshaller(MediaType.APPLICATION_JSON);
		StringWriter sw = new StringWriter();

		// when
		marshaller.marshal(objElement, sw);

		// then
		assertEquals(EXPECTED_OUTPUT_JSON, sw.toString());
	}

	@Test
	public void shouldMarshalStringElementToExpectedJSONOutput()
			throws JAXBException {
		// given
		StringElement objElement = new StringElement();
		Marshaller marshaller = aMarshaller(MediaType.APPLICATION_JSON);
		StringWriter sw = new StringWriter();

		// when
		marshaller.marshal(objElement, sw);

		// then
		assertEquals(EXPECTED_OUTPUT_JSON, sw.toString());
	}

	@Test
	public void shouldMarshalStringElementToExpectedXMLOutput()
			throws JAXBException {
		// given
		StringElement objElement = new StringElement();
		Marshaller marshaller = aMarshaller(MediaType.APPLICATION_XML);
		StringWriter sw = new StringWriter();

		// when
		marshaller.marshal(objElement, sw);

		// then
		assertEquals(EXPECTED_OUTPUT_XML, sw.toString());
	}

	@Test
	public void shouldMarshalObjectElementToExpectedXMLOutput()
			throws JAXBException {
		// given
		ObjectElement objElement = new ObjectElement();
		Marshaller marshaller = aMarshaller(MediaType.APPLICATION_XML);
		StringWriter sw = new StringWriter();

		// when
		marshaller.marshal(objElement, sw);

		// then
		assertEquals(EXPECTED_OUTPUT_XML, sw.toString());
	}

	private Marshaller aMarshaller(MediaType mediaType) throws JAXBException {
		JAXBContext jc = JAXBContextFactory.createContext(new Class[] {
				ObjectElement.class, StringElement.class }, null);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, mediaType);
		marshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);
		marshaller.setProperty("jaxb.fragment", Boolean.TRUE);
		return marshaller;
	}
}
