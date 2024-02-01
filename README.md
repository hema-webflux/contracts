# Contracts

#### Setting `publish.gradle`

```groovy
ext.'signing.keyId' = 'gpg密钥后8位'
ext.'signing.password' = '生成GPG密钥口令'
ext.'signing.secretKeyRingFile' = '/home/用户/.gradle/secret.gpg'
ext.'sonaUsername' = 'nexus username'
ext.'sonaPassword' = 'nexus password'
```

**Save to `/home/xxxx/.gradle/publish.gradle`**