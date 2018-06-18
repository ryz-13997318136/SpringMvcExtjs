
Ext.define('index.controller.indexController', {
    extend: 'Ext.app.Controller',

    init: function(application) {
    	this.control({
    		'indexView': {
    			afterrender: this.NoticeViewRander
    		},
    		'#menuTree':{
	        	itemclick: this.onBGGridClick
	        }
    	});
    },
    onBGGridClick:function(me, record){
    	if(record.data.leaf){
    		var main = Ext.getCmp('mainPanle');
    		var html = '<iframe scrolling="auto" frameborder="0" width="100%" height="100%" src="app.jsp?modules='+record.data.url+'"> </iframe>';
    		main.add(
					{
						xtype:'panel',
						html: html,
						title: record.data.text,
						closable : true
					}
				); 
    	}
    },
    // 表单界面一初始化
    NoticeViewRander: function(comp, eOpts) {
    		Ext.getStore('menuStore').getProxy().setExtraParam('userId','1528353989351');
    	    Ext.getStore('menuStore').load();
    
    },

});
