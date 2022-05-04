
Vue.prototype.ajax={
 addUrl: function (url,obj){
  if(arguments.length==1){
   obj=url;
   url=null;
  }
  if(!!url){
   for(var k in obj){
    url += (url.indexOf("?")==-1 ? "?" : "&");
    url+=encodeURIComponent(k)+ "=" +encodeURIComponent(obj[k]);
   }
  }else{
   url="";
   for(var k in obj){
    url+=encodeURIComponent(k)+ "=" +encodeURIComponent(obj[k]);
    url+="&";
   }
   var arr=url.split("");
   arr.pop();
   url=arr.join("");
  }
  return url;
 },
 get: function (url,data,fn,ojson){
  this.xhr=new XMLHttpRequest();
  if(typeof data =="function"){
   ojson=fn;
   fn=data;
   data={};
  }
  url=this.addUrl(url,data)
  this.xhr.open("get",url,true);
  this.xhr.send(null);
  this.success(fn,ojson);
  return this;
 },
 post: function (url,data,fn,ojson){
  this.xhr=new XMLHttpRequest();
  if(typeof data =="function"){
   ojson=fn;
   fn=data;
   data={};
  }
  data=this.addUrl(data);
  this.xhr.open("post",url,true);
  this.xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  this.xhr.send(data);

  this.success(fn,ojson);
  return this;
 },
 json: function (str){
  return (new Function("return " + str))();
 },
 success: function (fn,ojson){
  var self=this;
  this.xhr.onreadystatechange=function (){
   var odata;
   if(self.xhr.readyState == 4){
    if((self.xhr.status>=200 && self.xhr.status<300) || self.xhr.status == 304){
     odata=self.xhr.responseText;
     if(ojson==="json"){
      odata=self.json(odata);
     }
     fn(odata);
    }else{
     odata="request was unsuccessful: "+self.xhr.status;
     fn(odata);
    }
   }
  }
 },
 cancel: function (){
  this.xhr.abort();
  return this;
 }
}