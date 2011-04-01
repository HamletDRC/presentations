
@Grab(group='com.google.guava', module='guava', version='r08')
@Grab(group='com.google.guava', module='guava', version='r08', classifier='sources')
import com.google.common.base.Preconditions


userID = 1;
userName = "some name";


Preconditions.checkArgument(userID > 0, "userid is negative: %s", userID);
Preconditions.checkNotNull(userName, "user %s missing name", userID);
Preconditions.checkState(userName.size() > 0, "user %s missing name", userID);

