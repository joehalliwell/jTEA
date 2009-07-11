/**
 * Demo program for Trivial Encryption Algorithm (TEA) implementation.
 * See http://winterwell.com/software/TEA.php
 */

public class TEATest {

	public static String quote = "It is very strange, this domination of our intellect by our digestive organs.  We cannot work, we cannot think, unless our stomach wills so.  It dictates to us our emotions, our passions.  After eggs and bacon it says, \"Work!\"  After beefsteak and porter, it says, \"Sleep!\"  After a cup of tea (two spoonfuls for each cup, and don't let it stand for more than three minutes), it says to the brain, \"Now rise, and show your strength.  Be eloquent, and deep, and tender; see, with a clear eye, into Nature, and into life:  spread your white wings of quivering thought, and soar, a god-like spirit, over the whirling world beneath you, up through long lanes of flaming stars to the gates of eternity!\"";


	public static void main(String[] args) {
		/* Create a cipher using the first 16 bytes of the passphrase */
		TEA tea = new TEA("And is there honey still for tea?".getBytes());

		byte[] original = quote.getBytes();

		/* Run it through the cipher... and back */
		byte[] crypt = tea.encrypt(original);
		byte[] result = tea.decrypt(crypt);

		/* Ensure that all went well */
        String test = new String(result);
        if (!test.equals(quote))
		    throw new RuntimeException("FAIL");
	}
}
