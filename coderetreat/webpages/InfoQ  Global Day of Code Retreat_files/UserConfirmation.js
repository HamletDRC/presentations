
function UserConfirmation() { }
UserConfirmation._path = '/dwr';

UserConfirmation.confirm = function(p0, callback) {
    DWREngine._execute(UserConfirmation._path, 'UserConfirmation', 'confirm', p0, false, false, callback);
}
