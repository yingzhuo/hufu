package test;

import com.github.yingzhuo.hufu.api.Secret;
import com.github.yingzhuo.hufu.api.Signature;
import com.github.yingzhuo.hufu.impl.ecdsa.ECDSASecretFactory;
import com.github.yingzhuo.hufu.impl.ecdsa.ECDSASignature;
import org.junit.Test;

public class TestCases {

    @Test
    public void test1() {
        ECDSASecretFactory factory = new ECDSASecretFactory();
        Secret secret = factory.createRandom();

        System.out.println(secret.getPublicKey());
        System.out.println(secret.getPrivateKey());
    }

    @Test
    public void test2() {
        ECDSASecretFactory factory = new ECDSASecretFactory();
        Secret secret = factory.createRandom();

        System.out.println(secret.getPublicKey());
        System.out.println(secret.getPrivateKey());

        Signature signature = new ECDSASignature();
        String sign = signature.sign("123456", secret);

        System.out.println(sign);
        System.out.println(signature.verify("1234561", sign, secret));
    }

}
