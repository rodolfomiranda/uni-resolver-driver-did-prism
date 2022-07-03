package uniresolver.driver.did.prism;

// import com.apicatalog.jsonld.lang.Keywords;
import foundation.identity.did.DID;
import foundation.identity.did.DIDDocument;
import foundation.identity.did.Service;
import foundation.identity.did.VerificationMethod;
import foundation.identity.jsonld.JsonLDObject;
// import info.weboftrust.btctxlookup.Chain;
// import info.weboftrust.btctxlookup.bitcoinconnection.BTCDRPCBitcoinConnection;
import info.weboftrust.btctxlookup.bitcoinconnection.BitcoinConnection;
// // import info.weboftrust.btctxlookup.bitcoinconnection.BitcoindRPCBitcoinConnection;
// // import info.weboftrust.btctxlookup.bitcoinconnection.BlockcypherAPIBitcoinConnection;
// // import io.leonard.Base58;
// import org.apache.http.HttpEntity;
//import org.apache.http.client.HttpClient;
// import org.apache.http.client.methods.CloseableHttpResponse;
// import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.HttpClients;
// import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uniresolver.ResolutionException;
import uniresolver.driver.Driver;
import uniresolver.result.ResolveDataModelResult;
import uniresolver.result.ResolveResult;

// import javax.net.ssl.SSLContext;
// import javax.net.ssl.SSLSocketFactory;
// import javax.net.ssl.TrustManagerFactory;
// import java.io.ByteArrayInputStream;
// import java.io.IOException;
// import java.net.URI;
// import java.nio.charset.StandardCharsets;
// import java.security.KeyManagementException;
// import java.security.KeyStore;
// import java.security.KeyStoreException;
// import java.security.NoSuchAlgorithmException;
// import java.security.cert.Certificate;
// import java.security.cert.CertificateException;
// import java.security.cert.CertificateFactory;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rootsid.wal.library.DLTKt;
import kotlinx.serialization.json.JsonObject;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class DidPrismDriver implements Driver {

	public static final Pattern DID_PRISM_PATTERN_METHOD = Pattern.compile("^did:prism:(.*)$");
	public static final Pattern DID_PRISM_PATTERN_METHOD_SPECIFIC = Pattern
			.compile("^[a-z0-9]{4}-[a-z0-9]{4}-[a-z0-9]{4}-(?:[a-z0-9]{3}|[a-z0-9]{4}-[a-z0-9]{2})$");
	public static final String[] DIDDOCUMENT_VERIFICATIONMETHOD_TYPES = new String[]{"EcdsaSecp256k1VerificationKey2019"};
	public static final String[] DIDDOCUMENT_AUTHENTICATION_TYPES = new String[]{
			"EcdsaSecp256k1SignatureAuthentication2019"};
	private static final Logger log = LoggerFactory.getLogger(DidPrismDriver.class);
	private Map<String, Object> properties;
	// private BitcoinConnection bitcoinConnectionMainnet;
	// private BitcoinConnection bitcoinConnectionTestnet;
	//private HttpClient httpClient = HttpClients.createDefault();

	public DidPrismDriver() {

		this(getPropertiesFromEnvironment());
	}

	public DidPrismDriver(Map<String, Object> properties) {

		this.setProperties(properties);
	}

	private static Map<String, Object> getPropertiesFromEnvironment() {

		if (log.isDebugEnabled())
			log.debug("Loading from environment: " + System.getenv());

		Map<String, Object> properties = new HashMap<>();

		// try {

		// 	String env_bitcoinConnection = System.getenv("uniresolver_driver_did_btcr_bitcoinConnection");
		// 	String env_rpcUrlMainnet = System.getenv("uniresolver_driver_did_btcr_rpcUrlMainnet");
		// 	String env_rpcUrlTestnet = System.getenv("uniresolver_driver_did_btcr_rpcUrlTestnet");
		// 	String env_rpcCertMainnet = System.getenv("uniresolver_driver_did_btcr_rpcCertMainnet");
		// 	String env_rpcCertTestnet = System.getenv("uniresolver_driver_did_btcr_rpcCertTestnet");

		// 	if (env_bitcoinConnection != null)
		// 		properties.put("bitcoinConnection", env_bitcoinConnection);
		// 	if (env_rpcUrlMainnet != null)
		// 		properties.put("rpcUrlMainnet", env_rpcUrlMainnet);
		// 	if (env_rpcUrlTestnet != null)
		// 		properties.put("rpcUrlTestnet", env_rpcUrlTestnet);
		// 	if (env_rpcCertMainnet != null)
		// 		properties.put("rpcCertMainnet", env_rpcCertMainnet);
		// 	if (env_rpcCertTestnet != null)
		// 		properties.put("rpcCertTestnet", env_rpcCertTestnet);
		// } catch (Exception ex) {

		// 	throw new IllegalArgumentException(ex.getMessage(), ex);
		// }

		return properties;
	}

	// public BitcoinConnection getBitcoinConnectionMainnet() {
	// 	return bitcoinConnectionMainnet;
	// }

	// public BitcoinConnection getBitcoinConnectionTestnet() {
	// 	return bitcoinConnectionTestnet;
	// }

	@Override
	public ResolveDataModelResult resolve(DID did, Map<String, Object> resolveOptions) throws ResolutionException {

		// parse identifier

		Matcher matcher = DID_PRISM_PATTERN_METHOD.matcher(did.getDidString());
		if (!matcher.matches())
			return null;





		// try {


		// } catch (IOException ex) {

		// 	throw new ResolutionException(
		// 			"Cannot retrieve BTCR data for " + methodSpecificIdentifier + ": " + ex.getMessage(), ex);
		// }

		// if (log.isInfoEnabled())
		// 	log.info("Retrieved BTCR data for " + methodSpecificIdentifier + " (" + chainAndTxid + " on chain "
		// 			         + chainAndLocationData.getChain() + "): " + btcrData);


		// 		Map<String, Object> jsonLdObject = (Map<String, Object>) JsonLDObject.fromJson(EntityUtils.toString(httpEntity)).getJsonObject();


		// 		if (!emptyOrNull) {
		// 			didDocumentContinuation = DIDDocument.fromJsonObject(jsonLdObject);
		// 		}
		// 		else {
		// 			didDocumentContinuation = DIDDocument.builder().id(did.toUri()).build();
		// 		}


		// DID DOCUMENT contexts

		// List<URI> contexts = null;

		// if (didDocumentContinuation != null) {

		// 	contexts = didDocumentContinuation.getContexts();
		// }

		// // DID DOCUMENT verificationMethods

		// List<VerificationMethod> verificationMethods = new ArrayList<>();
		// List<VerificationMethod> authenticationVerificationMethods = new ArrayList<>();

		// List<String> inputScriptPubKeys = new ArrayList<>();


		// 	String keyId = did + "#key-" + (keyNum++);

		// 	VerificationMethod verificationMethod = VerificationMethod.builder()
		// 	                                                          .id(URI.create(keyId))
		// 	                                                          .types(Arrays.asList(DIDDOCUMENT_VERIFICATIONMETHOD_TYPES))
		// 	                                                          .publicKeyBase58(Base58.encode(HEX.decode(inputScriptPubKey)))
		// 	                                                          .build();
		// 	verificationMethods.add(verificationMethod);
		// }

		// VerificationMethod verificationMethod = VerificationMethod
		// 		.builder()
		// 		.id(URI.create(did + "#satoshi"))
		// 		.types(Arrays.asList(DIDDOCUMENT_VERIFICATIONMETHOD_TYPES))
		// 		.publicKeyBase58(Base58.encode(HEX.decode(inputScriptPubKeys.get(inputScriptPubKeys.size() - 1))))
		// 		.build();
		// verificationMethods.add(verificationMethod);

		// VerificationMethod authentication = VerificationMethod.builder()
		//                                               .types(Arrays.asList(DIDDOCUMENT_AUTHENTICATION_TYPES))
		//                                               .id(URI.create("#satoshi"))
		//                                               .build();
		// authenticationVerificationMethods.add(authentication);

		// if (didDocumentContinuation != null) {

		// 	if (didDocumentContinuation.getVerificationMethods() != null)
		// 		for (VerificationMethod didDocumentContinuationVerificationMethod : didDocumentContinuation.getVerificationMethods()) {

		// 			if (containsById(verificationMethods, didDocumentContinuationVerificationMethod))
		// 				continue;
		// 			verificationMethods.add(didDocumentContinuationVerificationMethod);
		// 		}

		// 	if (didDocumentContinuation.getAuthenticationVerificationMethods() != null)
		// 		for (VerificationMethod didDocumentContinuationAuthentication : didDocumentContinuation
		// 				.getAuthenticationVerificationMethods()) {

		// 			if (containsById(verificationMethods, didDocumentContinuationAuthentication))
		// 				continue;
		// 			authenticationVerificationMethods.add(didDocumentContinuationAuthentication);
		// 		}
		// }


		// // create DID DOCUMENT
		

		//String cw3cdod = DLTKt.getDidDocument("asdasd");

		DIDDocument didDocument = DIDDocument.builder()
		                                    //  .contexts(contexts)
		                                     .id(did.toUri())
		                                    //  .verificationMethods(verificationMethods)
		                                    //  .authenticationVerificationMethods(authenticationVerificationMethods)
		                                    //  .services(services)
		                                     .build();

		// // create METHOD METADATA

		Map<String, Object> didDocumentMetadata = new LinkedHashMap<>();
		// didDocumentMetadata.put("inputScriptPubKey", btcrData.getInputScriptPubKey());
		// didDocumentMetadata.put("continuationUri", btcrData.getContinuationUri());
		// if (didDocumentContinuation != null)
		// 	didDocumentMetadata.put("continuation", didDocumentContinuation);
		// if (chainAndLocationData != null)
		// 	didDocumentMetadata.put("chain", chainAndLocationData.getChain());
		// didDocumentMetadata.put("initialBlockHeight", initialChainAndLocationData.getLocationData().getBlockHeight());
		// didDocumentMetadata.put("initialTransactionPosition",
		//                    initialChainAndLocationData.getLocationData().getTransactionPosition());
		// didDocumentMetadata.put("initialTxoIndex", initialChainAndLocationData.getLocationData().getTxoIndex());
		// if (initialChainAndTxid != null)
		// 	didDocumentMetadata.put("initialTxid", initialChainAndTxid);
		// if (chainAndLocationData != null)
		// 	didDocumentMetadata.put("blockHeight", chainAndLocationData.getLocationData().getBlockHeight());
		// if (chainAndLocationData != null)
		// 	didDocumentMetadata.put("transactionPosition", chainAndLocationData.getLocationData().getTransactionPosition());
		// if (chainAndLocationData != null)
		// 	didDocumentMetadata.put("txoIndex", chainAndLocationData.getLocationData().getTxoIndex());
		// if (chainAndTxid != null)
		// 	didDocumentMetadata.put("txid", chainAndTxid);
		// didDocumentMetadata.put("spentInChainAndTxids", spentInChainAndTxids);
		// didDocumentMetadata.put("deactivated", btcrData.isDeactivated());

		// done

		URL url;
		StringBuilder resultado = new StringBuilder();

		try {
			url = new URL("https://www.google.com");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
  			String linea;
  			while ((linea = rd.readLine()) != null) {
    			resultado.append(linea);
  			}
		  rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// throw new ResolutionException("Cannot retrieve DID DOCUMENT CONTINUATION for "
		// 								+ methodSpecificIdentifier + " from " + btcrData.getContinuationUri() + ": " + ex.getMessage(),
		// 						ex);
		try {
			String w3cDoc = DLTKt.getDidDocumentJson(did.getDidString());
			// log.info("doc:" + w3cDoc.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ResolutionException(
					"Error in Prism SDK : " +  did.getDidString() +ex.getMessage(), ex);
		}




		

		//String nodeAuthApi = NodeAuthApiImpl();
		
		//  try {
		// 	PrismDid.fromString(did)
		// } catch (e: Exception) {
		// 	throw Exception("not a Prism DID: $did")
		// }
		// val prismDoc = runBlocking { nodeAuthApi.getDidDocument(prismDid) }

		// DIDDocument didDocument2 = DIDDocument.fromJson(w3cDoc.toString());
		// log.info("doc:" + didDocument2);

		return ResolveDataModelResult.build(null, didDocument, didDocumentMetadata);
	}

	@Override
	public Map<String, Object> properties() {

		return this.getProperties();
	}

	// public HttpClient getHttpClient() {

	// 	return this.httpClient;
	// }

	// public boolean containsById(List<? extends JsonLDObject> jsonLdObjectList, JsonLDObject containsJsonLdObject) {

	// 	for (JsonLDObject jsonLdObject : jsonLdObjectList) {

	// 		if (jsonLdObject.getId() != null && jsonLdObject.getId().equals(containsJsonLdObject.getId()))
	// 			return true;
	// 	}

	// 	return false;
	// }

	// public void setHttpClient(HttpClient httpClient) {

	// 	this.httpClient = httpClient;
	// }

	// private static SSLSocketFactory getSslSocketFactory(String certString) {
	// 	try {

	// 		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");

	// 		byte[] decoded = Base64.getDecoder().decode(certString.trim().getBytes(StandardCharsets.UTF_8));

	// 		Certificate certificate = certificateFactory.generateCertificate(new ByteArrayInputStream(decoded));

	// 		KeyStore keyStore = KeyStore.getInstance("JKS");
	// 		keyStore.load(null, null);
	// 		keyStore.setCertificateEntry("ca-cert", certificate);

	// 		TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	// 		trustManagerFactory.init(keyStore);

	// 		SSLContext context = SSLContext.getInstance("SSL");
	// 		context.init(null, trustManagerFactory.getTrustManagers(), null);
	// 		return context.getSocketFactory();

	// 	} catch (NoSuchAlgorithmException | KeyStoreException | CertificateException | KeyManagementException
	// 			| IOException e) {
	// 		log.error(e.getMessage(), e);
	// 	}
	// 	return null;
	// }


	// public void setBitcoinConnectionMainnet(BitcoinConnection bitcoinConnectionMainnet) {
	// 	this.bitcoinConnectionMainnet = bitcoinConnectionMainnet;
	// }

	// public void setBitcoinConnectionTestnet(BitcoinConnection bitcoinConnectionTestnet) {
	// 	this.bitcoinConnectionTestnet = bitcoinConnectionTestnet;
	// }

	private void configureFromProperties() {

		if (log.isDebugEnabled())
			log.debug("Configuring from properties: " + this.getProperties());

		// try {

		// 	// parse bitcoinConnection

		// 	String prop_bitcoinConnection = (String) this.getProperties().get("bitcoinConnection");

		// 	String prop_rpcUrlMainnet = (String) this.getProperties().get("rpcUrlMainnet");
		// 	String prop_rpcUrlTestnet = (String) this.getProperties().get("rpcUrlTestnet");
		// 	String prop_rpcCertTestnet = (String) this.getProperties().get("rpcCertTestnet");
		// 	String prop_rpcCertMainnet = (String) this.getProperties().get("rpcCertMainnet");

		// 	if ("bitcoind".equalsIgnoreCase(prop_bitcoinConnection)) {

		// 		if (prop_rpcUrlMainnet != null && !prop_rpcUrlMainnet.isBlank()) {
		// 			this.bitcoinConnectionMainnet = new BitcoindRPCBitcoinConnection(prop_rpcUrlMainnet, Chain.MAINNET);
		// 		}
		// 		if (prop_rpcUrlTestnet != null && !prop_rpcUrlTestnet.isBlank())
		// 			this.bitcoinConnectionTestnet = new BitcoindRPCBitcoinConnection(prop_rpcUrlTestnet, Chain.TESTNET);
		// 	}
		// 	else if ("btcd".equalsIgnoreCase(prop_bitcoinConnection)) {

		// 		if (prop_rpcUrlMainnet != null && !prop_rpcUrlMainnet.isBlank()) {
		// 			BTCDRPCBitcoinConnection btcdrpcBitcoinConnection = new BTCDRPCBitcoinConnection(prop_rpcUrlMainnet,
		// 			                                                                                 Chain.MAINNET);
		// 			if (prop_rpcCertMainnet != null && !prop_rpcCertMainnet.isBlank()) {

		// 				btcdrpcBitcoinConnection.getBitcoindRpcClient()
		// 				                        .setSslSocketFactory(getSslSocketFactory(prop_rpcCertMainnet));
		// 			}
		// 			this.bitcoinConnectionMainnet = btcdrpcBitcoinConnection;
		// 		}
		// 		if (prop_rpcUrlTestnet != null && !prop_rpcUrlTestnet.isBlank()) {
		// 			BTCDRPCBitcoinConnection btcdrpcBitcoinConnection = new BTCDRPCBitcoinConnection(prop_rpcUrlTestnet,
		// 			                                                                                 Chain.TESTNET);
		// 			if (prop_rpcCertTestnet != null && !prop_rpcCertTestnet.isBlank()) {
		// 				btcdrpcBitcoinConnection.getBitcoindRpcClient()
		// 				                        .setSslSocketFactory(getSslSocketFactory(prop_rpcCertTestnet));
		// 			}
		// 			this.bitcoinConnectionTestnet = btcdrpcBitcoinConnection;
		// 		}
		// 	}
		// 	else if ("bitcoinj".equalsIgnoreCase(prop_bitcoinConnection)) {

		// 		throw new RuntimeException("bitcoinj is not implemented yet");
		// 	}
		// 	else if ("blockcypherapi".equalsIgnoreCase(prop_bitcoinConnection)) {

		// 		this.setBitcoinConnectionMainnet(new BlockcypherAPIBitcoinConnection());
		// 		this.setBitcoinConnectionTestnet(new BlockcypherAPIBitcoinConnection());
		// 	}
		// 	else {

		// 		throw new IllegalArgumentException("Invalid bitcoinConnection: " + prop_bitcoinConnection);
		// 	}
		// } catch (IllegalArgumentException ex) {

		// 	throw ex;
		// } catch (Exception ex) {

		// 	throw new IllegalArgumentException(ex.getMessage(), ex);
		// }
	}

	public Map<String, Object> getProperties() {

		return this.properties;
	}

	public void setProperties(Map<String, Object> properties) {

		// this.properties = properties;
		// this.configureFromProperties();
	}
}

