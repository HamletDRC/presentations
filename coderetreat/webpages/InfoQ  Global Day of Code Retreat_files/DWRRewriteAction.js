
function DWRRewriteAction() { }
DWRRewriteAction._path = '/dwr';

DWRRewriteAction.execute = function(p0, p1, callback) {
    DWREngine._execute(DWRRewriteAction._path, 'DWRRewriteAction', 'execute', p0, p1, false, false, false, callback);
}
