
var ConfirmValue;function CheckDel(CurrentElment,p_FormID,OperateName){var num=0;var _FormID=p_FormID!=null?p_FormID:"form1";var form=document.getElementById(_FormID);for(var i=0;i<form.elements.length;i++){var e=form.elements[i];if(e.checked==true){num=num+1;}}
OperateName=OperateName==null?"删除":OperateName;if(num==0){jAlertDialogs('请选择要'+OperateName+'的记录!',null,3000);return false;}
if(ConfirmValue!=null&&ConfirmValue){ConfirmValue=null;return true;}
if(ConfirmValue==null){jConfirm("您真的要"+OperateName+"吗？",null,function(r){if(r&&CurrentElment!=null){ConfirmValue=true;document.getElementById(CurrentElment.id).click();}});}
return false;}
function SelectAllByName(tempControl,p_Name){var theBox=tempControl;xState=theBox.checked;var _Names=document.getElementsByName(p_Name);for(var _i=0;_i<_Names.length;_i++){if(_Names[_i].type=="checkbox"&&_Names[_i].checked!=xState){_Names[_i].click();}}}
function SelectAllByContainerID(tempControl,p_ID){var xState=tempControl.checked;var _checkboxObjs=$("#"+p_ID).find("input[type='checkbox']");_checkboxObjs.each(function(_i,_t){var _this=$(_t);if(xState){_this.attr("Checked","");}
else{_this.removeAttr("Checked");}});}
var jConfirmPostValue;function jConfirmPost(CurrentElment,Msg){if(jConfirmPostValue!=null&&jConfirmPostValue){jConfirmPostValue=null;return true;}
Msg=Msg==null?"删除":Msg;if(jConfirmPostValue==null){jConfirm("您确定要"+Msg+"吗？",null,function(r){if(r&&CurrentElment!=null){jConfirmPostValue=true;document.getElementById(CurrentElment.id).click();}});}
return false;}
function PrintRange(p_StartString,p_EndString,p_fontsize){bdhtml=window.document.body.innerHTML;fmhtml=window.document.forms[0].innerHTML;prnhtml=fmhtml.substr(fmhtml.indexOf(p_StartString)+p_StartString.length);prnhtml=""+prnhtml;prnhtml=prnhtml.substring(0,prnhtml.indexOf(p_EndString));window.document.body.innerHTML=prnhtml;window.document.body.style.fontSize=20;if(p_fontsize!=null){window.document.body.style.fontSize=p_fontsize;}
window.print();window.document.body.innerHTML=bdhtml;}
function EnterToTab(s_ContainerID){s_ContainerID=s_ContainerID?"#"+s_ContainerID+' ':'';$(s_ContainerID+"input:text:first").focus();var $inp=$(s_ContainerID+'input,select,textarea,.dropdown').filter(":text,:button,:submit,:radio,:password,:checkbox,select,textarea,div").not(":hidden,[readonly]");$inp.filter(":text,:radio,:password,:checkbox,select,div").keydown(function(e){var key=e.which;if(key==13){e.preventDefault();var nxtIdx=$inp.index(this)+1;$inp.eq(nxtIdx).focus();}});}
function MouseoverFocus(){var $inp=$('input,textarea').filter(":text,:password,textarea").not("[readonly]");$inp.mouseenter(function(){this.focus();});}
function SelectAllTxtByFocus(p_JquerySelector){$(p_JquerySelector).focus(function(e){e.currentTarget.select();});}
function EnterNextFocus(p_CurrentID,p_CurrentNextID){$("#"+p_CurrentID).keydown(function(e){if(e.which==13){e.preventDefault();$("#"+p_CurrentNextID).focus();}});}
function CopyTitle(p_this){window.clipboardData.setData("Text",p_this.title.replace("（双击复制）",""));document.selection.empty();}
function GetAbsoluteLocationEx(element){if(arguments.length!=1||element==null){return null;}
var elmt=element;var offsetTop=elmt.offsetTop;var offsetLeft=elmt.offsetLeft;var offsetWidth=elmt.offsetWidth;var offsetHeight=elmt.offsetHeight;while(elmt=elmt.offsetParent){if(elmt.style.position=='absolute'||elmt.style.position=='relative'||(elmt.style.overflow!='visible'&&elmt.style.overflow!='')){break;}
offsetTop+=elmt.offsetTop;offsetLeft+=elmt.offsetLeft;}
return{absoluteTop:offsetTop,absoluteLeft:offsetLeft,offsetWidth:offsetWidth,offsetHeight:offsetHeight};}
function show(obj){var bdiv=document.getElementById("showbz");bdiv.style.display="";document.getElementById("nr").innerHTML=obj.title;var loca=GetAbsoluteLocationEx(obj);$(bdiv).css("top",loca.absoluteTop-$(bdiv)[0].scrollHeight+loca.offsetHeight);$(bdiv).css("left",loca.absoluteLeft-$(bdiv)[0].scrollWidth-5);}
function closebz(){var bdiv=document.getElementById("showbz");bdiv.style.display="none";}
function RequestParam(paras,strhref){var url=strhref;var paraString=url.substring(url.indexOf("?")+1,url.length).split("&");var paraObj={}
for(i=0;j=paraString[i];i++){paraObj[j.substring(0,j.indexOf("=")).toLowerCase()]=j.substring(j.indexOf("=")+1,j.length);}
var returnValue=paraObj[paras.toLowerCase()];if(typeof(returnValue)=="undefined"){return"";}else{return returnValue;}}
function getUrlParam(name){var reg=new RegExp("(^|&)"+name+"=([^&]*)(&|$)");var r=window.location.search.substr(1).match(reg);if(r!=null)return unescape(r[2]);return null;}
function LocationHref(s_URL){AjaxMessageSwitch(true);window.location.href=s_URL;}
function autoSetQueryString(url,param,value){var reg=new RegExp("(?:([\?|&])"+param+"=(?:[^&]*))|(?:([\?|&]{0,1})(?:[^&\?]*$))");url=url.replace(reg,function(r,prefix,prefix_last){if(typeof(prefix)!="undefined"&&prefix!=''){return prefix+param+"="+value;}else{if(prefix_last!=""){if(r.length==1){return prefix_last+param+"="+value;}else{return r+"&"+param+"="+value;}}else{return r+"?"+param+"="+value;}}});return url;}
function GetICPWD(CallBack){AjaxMessageSwitch(true);$.ajax("../SystemSetting/SystemParameter.aspx/GetMWRFATLPWD",{type:"post",dataType:"json",contentType:"application/json; charset=utf-8",beforeSend:function(x){x.setRequestHeader("Content-Type","application/json; charset=utf-8");},success:function(e){AjaxMessageSwitch(false);var JSON=eval("("+e.d+")");if(JSON["Msg"]!=""){jAlertDialogs(JSON_PWD["Msg"]);return;}
else{CallBack(JSON["PWD"]==""?"ffffffffffff":JSON["PWD"]);}},error:function(){AjaxMessageSwitch(false);jAlertDialogs("获取感应式IC卡密码错误！");}});}
function isNum(i,obj,n_decimalLength){var txtlength=2;if(document.getElementById('txtxsws')!=null){txtlength=document.getElementById('txtxsws').value;}
if(!n_decimalLength)n_decimalLength=txtlength;var r1=new RegExp("^(-|0|([1-9]+[0-9]*))([0-9]+)?(\\.[0-9]{0,"+n_decimalLength+"})?$");var r2=new RegExp("^(-|0|([1-9]+[0-9]*))([0-9]+)?(\\.[0-9]{0,"+n_decimalLength+"})?");var r3=/^0+\.([0-9]|[0-9][0-9])?$|^0$|^1(\.0{0,2})?$/;var r4=/^0+\.([0-9]{3,4}|[0-9])?|^0|^1(\.0{0,2})?/;var r5=/^\d*$/;var r6=/^\d*/;var r7=new RegExp("^(-|0|([1-9]+[0-9]*))([0-9]+)?(\\.[0-9]{0,2})?$");var r8=new RegExp("^(-|0|([1-9]+[0-9]*))([0-9]+)?(\\.[0-9]{0,2})?");switch(i){case 1:if(!obj.value.match(r1)){if(obj.value.match(r2)){obj.value=obj.value.match(r2)[0];}
else{obj.value='';}}
break;case 2:if(!obj.value.match(r3)){if(obj.value.match(r4)){obj.value=obj.value.match(r4)[0];}
else{obj.value='';}}
break;case 3:if(!obj.value.match(r5)){if(obj.value.match(r6)){obj.value=obj.value.match(r6)[0];}
else{obj.value='';}}
break;case 4:if(!obj.value.match(r7)){if(obj.value.match(r8)){obj.value=obj.value.match(r8)[0];}
else{obj.value='';}}
break;}}
function setTxt(i,obj){var r1=/\.00$/;var r2=/\.000$/;switch(i){case 1:if(obj.value.match(r1)){obj.value=obj.value.slice(1).replace(r1,'');}
else{obj.value=obj.value.slice(1);}
break;case 2:if(obj.value.match(r1)){obj.value=obj.value.replace('￥','').replace(r1,'');}
else{obj.value=obj.value.replace('￥','');}
break;}
obj.select();}
function format(i,obj,n_decimalLength){var txtlength=2;var r1=/\.[0-9][0-9]$/;var r2=/\.$/;var r3=/\.[0-9]$/;if(document.getElementById('txtxsws')!=null){txtlength=document.getElementById('txtxsws').value;}
if(!n_decimalLength)n_decimalLength=txtlength;switch(i){case 1:obj.value="￥"+Number(obj.value);break;case 2:obj.value="￥"+Number(obj.value).toFixed(2);break;case 3:if(obj.value==''||obj.value.length==0){obj.value='1.00';}
break;case 4:if(obj.value==''||obj.value.length==0){obj.value='1';}
break;}}
function brs(ua){ua=ua.toLowerCase();var match=/(webkit)[ \/]([\w.]+)/.exec(ua)||/(msie) ([\w.]+)/.exec(ua)||!/compatible/.test(ua)&&/(mozilla)(?:.*? rv:([\w.]+))?/.exec(ua)||/(opera)(?:.*version)?[ \/]([\w.]+)/.exec(ua)||[];return{browser:match[1]||"",version:match[2]||"0"};}
function AddyssjSelect(p_ContainerID,p_JSONyssj,CallBack){var ObjJQ_ContainerID=$("#"+p_ContainerID);ObjJQ_ContainerID.empty();if(p_JSONyssj===undefined||p_JSONyssj.length==0)return;var El_ShowHiddenHref=document.createElement("a");var ObjJQ_ShowHiddenHref=$(El_ShowHiddenHref);var El_Selectyssj=document.createElement("select");var ObjJQ_Selectyssj=$(El_Selectyssj);ObjJQ_ShowHiddenHref.addClass("ArrowRight").attr("title","选择预设售价");ObjJQ_ContainerID.append(ObjJQ_ShowHiddenHref).append("&nbsp;").append(ObjJQ_Selectyssj.hide());var El_option=document.createElement("option");var ObjJQ_option=$(El_option);ObjJQ_option.attr("value","").text("");ObjJQ_Selectyssj.append(ObjJQ_option);for(_i=0;_i<p_JSONyssj.length;_i++){var El_option=document.createElement("option");var ObjJQ_option=$(El_option);ObjJQ_option.attr("value",p_JSONyssj[_i]["sj"]).text(p_JSONyssj[_i]["bt"]+"："+p_JSONyssj[_i]["sj"]);ObjJQ_Selectyssj.append(ObjJQ_option);}
ObjJQ_ShowHiddenHref.click(function(){if(ObjJQ_Selectyssj.is(":visible")){ObjJQ_ShowHiddenHref.attr("class","ArrowRight").attr("title","选择预设售价");ObjJQ_Selectyssj.hide();}
else{ObjJQ_ShowHiddenHref.attr("class","ArrowLeft").attr("title","隐藏预设售价");var n_top=ObjJQ_ShowHiddenHref.offset().top;var n_left=ObjJQ_ShowHiddenHref.offset().left;ObjJQ_Selectyssj.css({position:'Fixed',top:n_top-6,left:n_left+20});ObjJQ_Selectyssj.show();}});ObjJQ_Selectyssj.change(function(){if(CallBack!=null){CallBack(ObjJQ_Selectyssj.val());}
ObjJQ_ShowHiddenHref.click();});}
function AddyssjShow(p_ContainerID,p_JSONyssj){var ObjJQ_ContainerID=$("#"+p_ContainerID);var s_yssj="";ObjJQ_ContainerID.empty();if(p_JSONyssj.length==0)return;for(var _i=0;_i<p_JSONyssj.length;_i++){s_yssj+="["+p_JSONyssj[_i]["bt"]+":"+p_JSONyssj[_i]["sj"]+"] ";}
ObjJQ_ContainerID.append(s_yssj);}
function DisabledBtn(p_BtnID){setTimeout(function(){var JQ_btn=$("#"+p_BtnID);JQ_btn.attr("disabled","true");},1);}
function DisabledDOM(s_JquerySelector){$(s_JquerySelector).attr("disabled","disabled").addClass("DisabledBG");}
function EnabledDOM(s_JquerySelector){$(s_JquerySelector).removeAttr("disabled").removeClass("DisabledBG");}
function EnPunctuationToFull(str){var r_Reg=new RegExp("[\,|\;|\.|\:|\[|\\]|\{|\\}|'|\"]");var tmp='';str=$.trim(str);for(var i=0;i<str.length;i++){tmp+=r_Reg.test(str[i])?String.fromCharCode(str.charCodeAt(i)+65248):str[i];}
return tmp;}
function GetCurrentIframeID(){return window.parent.getIframeByElement(document.body).id;}
function str2DateTime(strDate,timeFormat){var config={year:{data:null,formatReg:/yyyy/,dateReg:/(?:(?:19|20)[0-9]{2})/,mixReg:/^\d{4}/},month:{data:null,formatReg:/M{1,2}/,dateReg:/(?:[0][1-9])|(?:[1][0-2])|(?:[1-9])/,mixReg:/^[1-9]{1}/},day:{data:null,formatReg:/d{1,2}/,dateReg:/(?:[0-2][0-9])|(?:[3][0-1])|(?:[1-9])/,mixReg:/^[1-9]{1}/},hour:{data:null,formatReg:/H{1,2}/,dateReg:/(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])/,mixReg:/^\d{1}/},minute:{data:null,formatReg:/m{1,2}/,dateReg:/(?:[0-5][0-9])|(?:[0-9])/,mixReg:/^\d{1}/},seconds:{data:null,formatReg:/s{1,2}/,dateReg:/(?:[0-5][0-9])|(?:[0-9])/,mixReg:/^\d{1}/}};function fn(str,format){var currItem=null,minIndex=-1;for(var i in config){match=format.match(config[i].formatReg);if(match==null){}else{if(currItem==null){currItem=config[i];minIndex=match.index;}else{if(minIndex>match.index){currItem=config[i];minIndex=match.index;}}}}
var status=true;if(currItem==null){}else{var data_match=str.match(currItem.dateReg)
if(data_match==null){status=false;}else{var data=data_match[0];var str_before=str.substring(0,data_match.index);var str_after=str.substring(data_match.index+data.length);var format_new=format.replace(currItem.formatReg,"");status=fn(str_before+str_after,format_new);if(status==true){currItem.data=data;}else{if(currItem.mixReg.test(data)){var data_2=data.match(currItem.mixReg)[0];str_after=str.substring(data_match.index+data_2.length);status=fn(str_before+str_after,format_new);if(status==true){currItem.data=data_2;}}}}}
return status;}
fn(strDate,timeFormat||"yyyy-M-d HH:mm:ss");var year,month,day,hour,minute,seconds;year=config.year.data;month=config.month.data;day=config.day.data;hour=config.hour.data;minute=config.minute.data;seconds=config.seconds.data;var date="";date+=year?year:"2013";date+="\/";date+=month?month:"01";date+="\/";date+=day?day:"01";date+=" ";date+=hour?hour:"00";date+=":";date+=minute?minute:"00";date+=":";date+=seconds?seconds:"00";return new Date(date);}
function dateTime2Str(date,timeFormat){var year=date.getFullYear();var month=date.getMonth()+1;var day=date.getDate();var hour=date.getHours();var minute=date.getMinutes();var seconds=date.getSeconds();timeFormat=timeFormat||"yyyy-MM-dd HH:mm:ss";var strDate=timeFormat.replace(/yyyy/,function(p){return year.toString();}).replace(/M{1,2}/,function(p){if(p.length==1){return month.toString();}else{return month<10?'0'+month.toString():month.toString();}}).replace(/d{1,2}/,function(p){if(p.length==1){return day.toString();}else{return day<10?'0'+day.toString():day.toString();}}).replace(/H{1,2}/,function(p){if(p.length==1){return hour.toString();}else{return hour<10?'0'+hour.toString():hour.toString();}}).replace(/h{1,2}/,function(p){if(hour>=12){hour-=12;}
if(p.length==1){return hour.toString();}else{return hour<10?'0'+hour.toString():hour.toString();}}).replace(/m{1,2}/,function(p){if(p.length==1){return minute.toString();}else{return minute<10?'0'+minute.toString():minute.toString();}}).replace(/s{1,2}/,function(p){if(p.length==1){return seconds.toString();}else{return seconds<10?'0'+seconds.toString():seconds.toString();}});return strDate;}
function getSiteRootPath(){var els=document.getElementsByTagName('script'),src;for(var i=0,len=els.length;i<len;i++){src=els[i].src||'';if(/\/script\/common[\w\-\.]*\.js/.test(src)){return src.substring(0,src.lastIndexOf('/script/common.js')+1);}}
return'';}
(function($){$.fn.extend({'Enter':function(Fun){this.keydown(function(e){if(e.which==13){return Fun(e);}});}});})(jQuery);(function($){$.extend({'FastInputTxt':function(Fun){var n_TimeSpan=50;var s_InputString;var d_LastInputDate=new Date();jQuery(document).keydown(function(e){var d_NowDate=new Date();switch(e.which){case 13:s_InputString=(d_NowDate-d_LastInputDate)>n_TimeSpan?"":s_InputString;var s_ReturnStrg=s_InputString.replace(/[^(0-9|a-z|A-Z)]/g,'');s_InputString='';if(s_ReturnStrg!=""&&s_ReturnStrg.length>2)return Fun(s_ReturnStrg);break;default:s_InputString=(d_NowDate-d_LastInputDate)>n_TimeSpan?String.fromCharCode(e.which):(s_InputString+=String.fromCharCode(e.which));d_LastInputDate=new Date();break;}});}});})(jQuery);function ToFlexiGridJSON(JSONArray){var FlexiGridJSON={"total":"0","page":"1","rows":""};FlexiGridJSON.total=JSONArray.length;var RowsArray=[];for(var i=0;i<JSONArray.length;i++){RowsArray[i]={"id":"1","cell":""};RowsArray[i]["cell"]=JSONArray[i];};FlexiGridJSON.rows=RowsArray;return FlexiGridJSON;}
function ToJSONArrayByFlexiGridData(FlexiGridData){if(FlexiGridData==undefined)return[];var _Rows=FlexiGridData.rows;var _RowArray=[];for(var i=0;i<_Rows.length;i++){_RowArray[i]=_Rows[i]["cell"];}
return _RowArray;}
function GetCurrentSoftID(b_ForServer){var _SiteRootPath=getSiteRootPath();var _storageKey=_SiteRootPath+"CurrentSoftID";if(!localStorage.getItem(_storageKey)||b_ForServer){$.ajax({type:"POST",url:_SiteRootPath+"api/GetSoftCurrentHandler.ashx?rand="+parseInt(Math.random()*100000000),data:{},async:false,dataType:"json",success:function(data){if(data.status==0){localStorage.setItem(_storageKey,data.CurrentSoftID);}}});}
return localStorage.getItem(_storageKey);}
function GetCurrentSoftMenus(b_ForServer){var _SiteRootPath=getSiteRootPath();var _storageKey=_SiteRootPath+"CurrentSoftMenus";if(!localStorage.getItem(_storageKey)||b_ForServer){$.ajax({type:"get",url:_SiteRootPath+"JS/SystemConfig/menu/"+GetCurrentSoftID()+"/menu.js?rand="+parseInt(Math.random()*100000000),data:{},async:false,dataType:"text",success:function(data){localStorage.setItem(_storageKey,data);}});}
return localStorage.getItem(_storageKey);}
var arr_ModelJsonJSList=["JSONCommModel"];function GetSoftModelJson(b_Server){var _SiteRootPath=getSiteRootPath();for(var i=0;i<arr_ModelJsonJSList.length;i++){if(!localStorage.getItem(_SiteRootPath+arr_ModelJsonJSList[i])||b_Server){$.ajax({type:"get",url:_SiteRootPath+"JS/SystemConfig/Business/"+GetCurrentSoftID()+"/"+arr_ModelJsonJSList[i]+".js?rand="+parseInt(Math.random()*100000000),data:{},async:false,dataType:"text",success:function(data){localStorage.setItem(_SiteRootPath+arr_ModelJsonJSList[i],data);}});}
eval("("+localStorage.getItem(_SiteRootPath+arr_ModelJsonJSList[i])+")");}}
function GetSystemParameter(){if(window.SysPar==undefined){var _SiteRootPath=getSiteRootPath();$.ajax({type:"POST",url:_SiteRootPath+"SystemSetting/ashx/SystemParameter.ashx?rand="+parseInt(Math.random()*100000000),data:{},async:false,dataType:"json",success:function(data){window.SysPar=data;}});}
return window.SysPar;}
function CheckClientServerRunBC(){if(parent.OpenDeviceSetting)parent.OpenDeviceSetting();}
function showCoverPannel(p_IsShow){if(p_IsShow){var pannel=$(".coverPannel");if(pannel.length==0){var html='<div class="coverPannel"><div class="loading"><div class="coverPannel_img"></div></div></div>';$("body").append(html);pannel=$(".coverPannel")}
pannel.show();}
else{$(".coverPannel").hide();}}
function GetColor(containerfu,containerzi){var counts=$('#'+containerfu+'>'+containerzi);for(var i=0;i<counts.length;i++){if(i%2!=0){counts[i].style.backgroundColor='#fff2f2';}else{counts[i].style.backgroundColor='';}}}
function SelectTrFrist(s_TableID){var JQ_Table=$("#"+s_TableID);if(JQ_Table.find("tr").length>2){JQ_Table.find("tr:eq(1)")[0].className="bk_data_select";}}
function getNowFormatDate(){var date=new Date();var seperator1="-";var month=date.getMonth()+1;var strDate=date.getDate();if(month>=1&&month<=9){month="0"+month;}
if(strDate>=0&&strDate<=9){strDate="0"+strDate;}
var currentdate=date.getFullYear()+seperator1+month+seperator1+strDate;return currentdate;}
function dblTableTr(s_TableID,f_dbl){var JQ_TableTr=$("#"+s_TableID).find("tr:not(:last):not(:first)");JQ_TableTr.dblclick(f_dbl);}
function gettime(timespan){var currentDate=new Date();var milliseconds=currentDate.getTime();milliseconds=milliseconds-1000*3600*24*timespan;var time=new Date();time.setTime(milliseconds);return time;}
function formatTen(num){return num>9?(num+""):("0"+num);}
function formatDate(date){var year=date.getFullYear();var month=date.getMonth()+1;var day=date.getDate();var hour=date.getHours();var minute=date.getMinutes();var second=date.getSeconds();return year+"-"+formatTen(month)+"-"+formatTen(day);}
function getjbrindex(selectid,localvalue){if(salejbr!=null&&salejbr!=''){$('#'+selectid).find('option').eq(localvalue).attr("selected","selected");}}
function substrLeft(s_str,n_len){if(s_str.length>n_len){return s_str.substring(0,n_len)+"...";}
return s_str;}