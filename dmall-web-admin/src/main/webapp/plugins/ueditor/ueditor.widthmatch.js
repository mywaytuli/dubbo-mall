;(function(){
        if(UE && UE.getEditor){
                UE._sodo_getEditor = UE.getEditor;
                UE.getEditor = function (id, opt) {
                var editor = UE._sodo_getEditor(id, opt);
                editor.addListener( 'contentChange', function( event ) {
                        $(editor.body).find("img,table").css("width", "100%");
                        $(editor.body).find("td,th").css("width", "0").css("border", "1px solid #333");
                });
                return editor;
            };
        } else {
                alert("未引入ueditor插件");
        }
})();