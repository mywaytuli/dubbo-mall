/**
 * ueditor for sodo config
 */

(function () {
	UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
	UE.Editor.prototype.getActionUrl = function(action) {
	    if (action == 'uploadimage') {
	        return 'upload_image.do';
	    } else if (action == 'listimage') {
	    	return 'list_image.do';
	    } else {
	        return this._bkGetActionUrl.call(this, action);
	    }
	}

})();

function initEditor(editorId, height) {
	return UE.getEditor(editorId, {
        initialFrameHeight: height,
    	serverUrl: 'editor_config',
    });
}

