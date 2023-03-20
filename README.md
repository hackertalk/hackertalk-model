# HackerTalk Model

## AWS CodeArtifact Authorization

```shell
export CODEARTIFACT_AUTH_TOKEN=`aws codeartifact get-authorization-token --domain tonggan --domain-owner 694979835041 --region us-east-1 --query authorizationToken --output text`
```
