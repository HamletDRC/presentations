
package guava;

import com.google.common.base.Preconditions;

public class _02PreconditionsExample {
    public static void main(String[] args) {
        int userID = 1;
        String userName = "some name";


        Preconditions.checkArgument(userID > 0, "userid is negative: %s", userID);
        Preconditions.checkNotNull(userName, "user %s missing name", userID);
        Preconditions.checkState(userName.length() > 0, "user %s missing name", userID);
    }

}
