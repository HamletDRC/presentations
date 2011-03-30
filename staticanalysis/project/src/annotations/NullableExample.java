package annotations;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NullableExample {

    @Nullable
    Integer getId() {
        return 1;
    }

    @NotNull
    String getName() {
        return "name";
    }
    
    @Override
    public String toString() {
        if (getName() == null) {
            return getId().toString() + "<unknown>";
        } else {
            return getId().toString() + getName();
        }
    }
}
