![DIF Logo](https://raw.githubusercontent.com/decentralized-identity/universal-resolver/master/docs/logo-dif.png)

# Universal Resolver Driver: did:prism

This is a [Universal Resolver](https://github.com/decentralized-identity/universal-resolver/) driver for **did:prism** identifiers.

## Specifications

* [Decentralized Identifiers](https://w3c.github.io/did-core/)
* DID Method Specification (pending)


## Example DIDs

```
 ddid:prism:5100054ac26b61aee90d632f58a1d8dac85680a9b76045bd6c7140c1ba54e9c7
```

## Build and Run (Docker)

```
docker build -f ./docker/Dockerfile . -t universalresolver/driver-did-prism
docker run -p 8080:8080 universalresolver/driver-did-prism
curl -X GET http://localhost:8080/1.0/identifiers/did:prism:db47e78dd57d2043a7a704fbd9d186a586682110a2097ac06dbc83b35602f290
```

## Build (native Java)

	mvn clean install --settings settings.xml
	
## Driver Environment Variables

The driver recognizes the following environment variables:

### `uniresolver_driver_did_btcr_bitcoinConnection`

 * Specifies how the driver interacts with the Bitcoin blockchain.
 * Possible values: 
   * `bitcoind`: Connects to a [bitcoind](https://bitcoin.org/en/full-node) instance via JSON-RPC
   * `btcd`: Connects to a [btcd](https://github.com/btcsuite/btcd) instance via JSON-RPC
   * `bitcoinj`: Connects to Bitcoin using a local [bitcoinj](https://bitcoinj.github.io/) client
   * `blockcypherapi`: Connects to [BlockCypher's API](https://www.blockcypher.com/dev/bitcoin/)
 * Default value: `blockcypherapi`





