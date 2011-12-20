
function UserCategoryUtil() { }
UserCategoryUtil._path = '/dwr';

UserCategoryUtil.getExcludedCategories = function(p0, callback) {
    DWREngine._execute(UserCategoryUtil._path, 'UserCategoryUtil', 'getExcludedCategories', p0, false, callback);
}

UserCategoryUtil.getIncludedCategories = function(p0, callback) {
    DWREngine._execute(UserCategoryUtil._path, 'UserCategoryUtil', 'getIncludedCategories', p0, false, callback);
}

UserCategoryUtil.excludeCategory = function(p0, callback) {
    DWREngine._execute(UserCategoryUtil._path, 'UserCategoryUtil', 'excludeCategory', p0, false, callback);
}

UserCategoryUtil.includeCategory = function(p0, callback) {
    DWREngine._execute(UserCategoryUtil._path, 'UserCategoryUtil', 'includeCategory', p0, false, callback);
}

UserCategoryUtil.autosuggest = function(p0, p1, p2, callback) {
    DWREngine._execute(UserCategoryUtil._path, 'UserCategoryUtil', 'autosuggest', p0, p1, p2, callback);
}

UserCategoryUtil.getAllCategories = function(p0, p1, callback) {
    DWREngine._execute(UserCategoryUtil._path, 'UserCategoryUtil', 'getAllCategories', p0, p1, callback);
}
