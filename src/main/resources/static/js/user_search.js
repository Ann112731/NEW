$(document).ready(function() { 
    var content = [{ 
     title: '借阅记录' 
    }, { 
     title: '借阅书籍' 
    }, { 
     title: '归还书籍' 
    }, { 
     title: '查询书籍' 
    },{
      title:'用户信息管理'
    },{
      title:'E-mail Support'
    }]; 

    $('.ui.search') 
     .search({ 
      type: 'standard', 
      source: content, 
      searchFields: ['title'], 
     }); 

   }); 