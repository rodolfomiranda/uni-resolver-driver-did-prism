package uniresolver.driver.did.prism;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.rootsid.wal.library.DLTKt;
import foundation.identity.did.DID;
import foundation.identity.did.DIDDocument;
import kotlinx.serialization.json.JsonObject;
import uniresolver.ResolutionException;
import uniresolver.driver.Driver;
import uniresolver.result.ResolveDataModelResult;

public class DidPrismDriver implements Driver {

	public static final Pattern DID_PRISM_PATTERN_METHOD = Pattern.compile("^did:prism:(.*)$");
	public static final Pattern DID_PRISM_PATTERN_METHOD_SPECIFIC = Pattern
			.compile("^[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4}-(?:[a-z0-9]{3}|[a-z0-9]{4}-[a-z0-9]{2})$");
	private static final Logger log = LoggerFactory.getLogger(DidPrismDriver.class);
	private Map<String, Object> properties;

	public DidPrismDriver() {

		this(getPropertiesFromEnvironment());
	}

	public DidPrismDriver(Map<String, Object> properties) {

		this.setProperties(properties);
	}

	@Override
	public ResolveDataModelResult resolve(DID did, Map<String, Object> resolveOptions) throws ResolutionException {

		Matcher matcher = DID_PRISM_PATTERN_METHOD.matcher(did.getDidString());
		if (!matcher.matches())
			return null;

		Map<String, Object> didDocumentMetadata = new LinkedHashMap<>();
		try {
			JsonObject w3cDoc = DLTKt.getDidDocumentW3C(did.getDidString());
			// log.info("doc:" + w3cDoc.toString());
			DIDDocument didDocument2 = DIDDocument.fromJson(w3cDoc.toString());
			return ResolveDataModelResult.build(null, didDocument2, didDocumentMetadata);
		} catch (Exception ex) {
			throw new ResolutionException(
					"Error from Prism SDK : " + ex.getMessage(), ex);
		}
		
	}

	@Override
	public Map<String, Object> properties() {

		return this.getProperties();
	}

	public Map<String, Object> getProperties() {

		return this.properties;
	}

	public void setProperties(Map<String, Object> properties) {

		this.properties = properties;
		// this.configureFromProperties();
	}

	private static Map<String, Object> getPropertiesFromEnvironment() {

		if (log.isDebugEnabled())
			log.debug("Loading from environment: " + System.getenv());

		Map<String, Object> properties = new HashMap<>();

		return properties;
	}
}

