;(function($, window, document,undefined) {
    var CatalogSlt = function(ele, sltId, chgFunc) {
        this.$e = ele;
        this.sltId = "";
        this.$e.prepend("<input type='hidden' name='" + this.$e.data("inpname") + "'/>");
        this.$inp = this.$e.children("input[type=hidden]");
        this.$btn = this.$e.children("button");
        this.chgFunc = chgFunc;
        var that = this;
        (function bindClick(){
        	that.$e.find("a").click(function(){
        		var $a = $(this);
            	that.slt($a.data("cid"), $a.text());
            });
        })(that);
        if(sltId){
        	var name = this.$e.find("a[data-cid='" + sltId + "']").text();
        	this.slt(sltId, name, true);
        }
    }

    CatalogSlt.prototype = {
        slt: function(id, name, isInit) {
        	this.sltId = id;
        	this.$inp.val(id);
        	this.$btn.html(name + " <span class='caret'></span>").removeClass("open");
        	if(!isInit && this.chgFunc){
        		this.chgFunc(!id ? "" : id);
        	}
        	return this;
        }
    };

    $.fn.catalogSlt = function(slt, chgFunc) {
        return new CatalogSlt(this, slt, chgFunc);
    }
})(jQuery, window, document);