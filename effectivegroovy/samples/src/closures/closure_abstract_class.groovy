package closures

import groovy.transform.TupleConstructor

public abstract class TwoPhaseEncryptionInJava {

    public String perform(String text) {
        return phase2(phase1(text));
    }

    protected abstract String phase1(String text);
    protected abstract String phase2(String text);
}

public class ReversingRot13InJava extends TwoPhaseEncryptionInJava {

    protected String phase1(String text) {
        return new StringBuffer(text).reverse().toString();
    }

    protected String phase2(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'm') c += 13;
            else if (c >= 'n' && c <= 'z') c -= 13;
            else if (c >= 'A' && c <= 'M') c += 13;
            else if (c >= 'N' && c <= 'Z') c -= 13;
            result += c;
        }
        return result;
    }
}

println new ReversingRot13InJava().perform("...some data")

/**
 * Template Method Replacement
 */
@TupleConstructor(includeFields = true)
class TwoPhaseEncryption {

    private final phase1
    private final phase2

    public String perform(String text) {
        return phase2(phase1(text));
    }
}

class ReversingRot13 extends TwoPhaseEncryption {

    ReversingRot13() {
        super(phase1, phase2)
    }

    private static phase1 = {
        it.reverse()
    }

    private static phase2 = { text ->
        text.toCharArray().collect {
            switch (it) {
                case 'A'..'M': case 'a'..'m': return (it + 13) as char
                case 'N'..'Z': case 'n'..'z': return (it - 13) as char
                default: return (it as char)
            }
        }.join()
    }
}

println new ReversingRot13().perform("...some data")

/**
 * Strategy Pattern? Function Composition.
 */

def twoPhaseEncryption = { phase1, phase2, text ->
    phase2(phase1(text))
}

def reverseEncryption = { it.reverse() }
def rot13Encryption = { text -> 
    text.toCharArray().collect {
            switch (it) {
                case 'A'..'M': case 'a'..'m': return (it + 13) as char
                case 'N'..'Z': case 'n'..'z': return (it - 13) as char
                default: return (it as char)
            }
        }.join()
}

def reversingRot13 = twoPhaseEncryption.curry(reverseEncryption, rot13Encryption)

println reversingRot13("...some data")

/**
 * Command Pattern? 
 */
Collection.metaClass.shuffle = {
    Collections.shuffle(delegate)
    delegate
}

def encryptionCommands = [
        ROT13: rot13Encryption,
        REVERSE: reverseEncryption
]

def cmd = ['ROT13', 'REVERSE'].shuffle().head()

println encryptionCommands[cmd]("... some data")