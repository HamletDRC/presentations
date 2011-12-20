
function ForumNotifications() { }
ForumNotifications._path = '/dwr';

ForumNotifications.toggleNotifications = function(p0, p1, p2, callback) {
    DWREngine._execute(ForumNotifications._path, 'ForumNotifications', 'toggleNotifications', p0, p1, p2, callback);
}
