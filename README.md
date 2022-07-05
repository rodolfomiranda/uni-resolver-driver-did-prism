![DIF Logo](https://raw.githubusercontent.com/decentralized-identity/universal-resolver/master/docs/logo-dif.png)

# Universal Resolver Driver: did:prism

This is a [Universal Resolver](https://github.com/decentralized-identity/universal-resolver/) driver for **did:prism** identifiers.

## Specifications

* [Decentralized Identifiers](https://w3c.github.io/did-core/)
* DID Method Specification (pending)


## Example DIDs

```
 did:prism:db47e78dd57d2043a7a704fbd9d186a586682110a2097ac06dbc83b35602f290
```

## Build and Run (Docker)

```
docker build -f ./docker/Dockerfile . -t rodolfomiranda/driver-did-prism
docker run -p 8080:8080 rodolfomiranda/driver-did-prism
curl -X GET http://localhost:8080/1.0/identifiers/did:prism:db47e78dd57d2043a7a704fbd9d186a586682110a2097ac06dbc83b35602f290
```

## Build (native Java)

	mvn clean install --settings settings.xml
	
## Driver Environment Variables

The driver needs the following environment variables:

- PRISM_NODE_HOST= PRISM node such as `ppp-node-test.atalaprism.io`
- PRISM_NODE_PORT=PRISM port such as `50053`
- PRISM_SDK_USER= User to access Prism SDK (request to IOG)
- PRISM_SDK_PASSWORD= Password to access Prism SDK (request to IOG)
- GITHUB_USER= your github user
- GITHUB_TOKEN= github personal access token [(PAT](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)) with `read:packages` option enabled.
