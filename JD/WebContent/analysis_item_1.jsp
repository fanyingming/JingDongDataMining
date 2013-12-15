<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Analysis_Item_1</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <style>
      body {
        padding-top: 50px;
        padding-bottom: 20px;
      }
    </style>
    <script type="text/javascript" src="js/jquery-1.10.2.min.js" ></script>
    <script src="js/highcharts.js"></script>
    <script src="js/exporting.js"></script>

        <script type="text/javascript">
$(function () {
        var eval = [89.06,90.2,91.97,89.04,91.52,89.8,96.57,90.35,91.77,92.99,91.45,93.94,90.76,90,91.07,92.67,88.20,82.66,82.22,91.21,92.03,90.33,90.07];
        var sanxingkeywords = ['不错','系统','很好','漂亮','速度','外观','三星','win','价格','WIN'];
        var hairkeywords = ['不错','系统','很好','速度','开机','满意','外观','一般','问题','喜欢'];
        var thinkpadkeywords = ['不错','速度','很好','系统','价格','键盘','满意','性能','配置','挺好'];
        var dongzhikeywords = ['不错','系统','好好','很好','外观','配置','东芝','漂亮','性价比','机器'];
        var lenovokeywords = ['不错','系统','很好','速度','性价比','屏幕','外观','满意','方便','win'];
        var dellkeywords = ['不错','系统','外观','很好','win','配置','漂亮','非常','速度','满意'];
        var applekeywords = ['不错','苹果','很好','送货','系统','外观','价格','值得','很快','比较'];
        var acerkeywords = ['不错','很好','系统','外观','性价比','好好','屏幕','非常','win8','游戏'];
        var fushitongkeywords = ['不错','很好','性价比','散热','系统','速度','做工','漂亮','内存','机器'];
        var weilairenleikeywords = ['不错','游戏','系统','屏幕','键盘','散热','不过','机器','很好','满意'];
        var asuskeywords = ['不错','好好','很好','系统','比较','性价比','朋友','外观','价格','华硕'];
        var alienkeywords = ['不错','速度','配置','非常','外观','机器','送货','使用','挺好','显卡'];
        var tongfangkeywords = ['不错','速度','外观','系统','性价比','好好','非常','漂亮','ok','很快'];
        var gatewaykeywords = ['不错','很好','WIN','键盘','机器','散热','没的说','不行'];
        var hpkeywords = ['不错','系统','好好','win','外观','很好','开机','配置','win8','使用'];
        var leishekeywords = ['不错','散热','游戏','系统','苹果','外观','找到','联盟','莫名'];
        var shenzhoukeywords = ['不错','性能','系统','配置','性价比','游戏','很好','问题','屏幕','外观'];
        var qixikeywords = ['不错','系统','价格','速度','性价比','外观','知道','一般','屏幕','比较'];
        var youpaikeywords = ['很好','外观','使用','觉得','什么的'];
        var elsekeywords = ['不错','很好','漂亮','外观','系统','win','win8','比较','效果','散热'];
        var weixingkeywords = ['不错','游戏','很好','win','配置','速度','机器','win8','很快','满意'];
        var sonykeywords = ['不错','很好','系统','漂亮','外观','速度','索尼','win','价格','麻烦'];
        var jijiakeywords = ['不错','屏幕','系统','很好','内存','做工','一般','使用','支持','原因'];
        var sanxingcommetnum = [149,48,43,38,36,33,30,24,20,19];
        var haircommetnum = [53,26,21,16,14,13,12,11,10,9];
        var thinkpadcommetnum = [145,39,32,27,26,20,19,18,17,16];
        var dongzhicommetnum = [100,39,36,35,28,25,24,20,19,18];
        var lenovocommetnum = [156,65,36,32,25,22,19,17,16,15];
        var dellcommetnum = [170,64,38,34,31,29,27,26,25,23];
        var applecommetnum = [56,26,20,14,13,12,11,10,8,7];
        var acercommetnum = [131,84,32,27,26,24,23,20,19,18];
        var fushitongcommetnum = [71,28,20,19,18,17,16,15,14,13];
        var weilairenleicommetnum = [77,33,32,29,26,25,20,19,18,16];
        var asuscommetnum = [145,53,44,36,35,29,28,27,24,23];
        var aliencommetnum = [24,14,12,9,8,7,6,5,4,3];
        var tongfangcommetnum = [70,27,24,20,18,17,15,14,12,11];
        var gatewaycommetnum = [13,9,6,5,4,3,2,1];
        var hpcommetnum = [126,41,36,34,30,29,23,21,20,19];
        var leishecommetnum = [18,9,8,6,5,4,3,2,1];
        var shenzhoucommetnum = [127,36,34,33,31,26,24,22,19,18];
        var qixicommetnum = [63,23,18,17,15,10,9,8,7,6];
        var youpaicommetnum = [5,4,3,2,1];
        var elsecommetnum = [38,17,14,13,12,8,7,6,5,4];
        var weixingcommetnum = [99,42,29,25,22,21,19,18,16,15];
        var sonycommetnum = [106,59,53,42,36,35,29,21,18,17];
        var jijiacommetnum = [21,12,11,8,7,6,5,4,3,2];

        var colors = Highcharts.getOptions().colors,
            categories = ['三星', '海尔', 'Thinkpad', '东芝', '联想', 'Dell',
                    '苹果', '宏基', '富士通', '未来人类', 'Asus/华硕', '外星人', 
                    '清华同方', 'Gateway', '惠普', '雷蛇', '神舟', '七喜', 
                    '优派', '其他', '微星', '索尼', '技嘉'],
            name = 'Computer brands',
            data = [{
                    y: eval[0],
                    color: colors[0],
                    drilldown: {
                        name: '三星品牌评论关键词',
                        categories: [sanxingkeywords[0], sanxingkeywords[1], sanxingkeywords[2], sanxingkeywords[3], sanxingkeywords[4], sanxingkeywords[5], sanxingkeywords[6], sanxingkeywords[7], sanxingkeywords[8], sanxingkeywords[9]],
                        data: [sanxingcommetnum[0], sanxingcommetnum[1], sanxingcommetnum[2], sanxingcommetnum[3], sanxingcommetnum[4], sanxingcommetnum[5], sanxingcommetnum[6], sanxingcommetnum[7], sanxingcommetnum[8], sanxingcommetnum[9]],
                        color: colors[0]
                    }
                }, {
                    y: eval[1],
                    color: colors[1],
                    drilldown: {
                        name: '海尔品牌评论关键词',
                        categories: [hairkeywords[0], hairkeywords[1], hairkeywords[2], hairkeywords[3], hairkeywords[4], hairkeywords[5], hairkeywords[6], hairkeywords[7], hairkeywords[8], hairkeywords[9]],
                        data: [haircommetnum[0], haircommetnum[1], haircommetnum[2], haircommetnum[3], haircommetnum[4], haircommetnum[5], haircommetnum[6], haircommetnum[7], haircommetnum[8], haircommetnum[9]],
                        color: colors[1]
                    }
                }, {
                    y: eval[2],
                    color: colors[2],
                    drilldown: {
                        name: 'Thinkpad品牌评论关键词',
                        categories: [thinkpadkeywords[0], thinkpadkeywords[1], thinkpadkeywords[2], thinkpadkeywords[3], thinkpadkeywords[4], thinkpadkeywords[5], thinkpadkeywords[6], thinkpadkeywords[7], thinkpadkeywords[8], thinkpadkeywords[9]],
                        data: [thinkpadcommetnum[0], thinkpadcommetnum[1], thinkpadcommetnum[2], thinkpadcommetnum[3], thinkpadcommetnum[4], thinkpadcommetnum[5], thinkpadcommetnum[6], thinkpadcommetnum[7], thinkpadcommetnum[8], thinkpadcommetnum[9]],
                        color: colors[2]
                    }
                }, {
                    y: eval[3],
                    color: colors[3],
                    drilldown: {
                        name: '东芝品牌评论关键词',
                        categories: [dongzhikeywords[0], dongzhikeywords[1], dongzhikeywords[2], dongzhikeywords[3], dongzhikeywords[4], dongzhikeywords[5], dongzhikeywords[6], dongzhikeywords[7], dongzhikeywords[8], dongzhikeywords[9]],
                        data: [dongzhicommetnum[0], dongzhicommetnum[1], dongzhicommetnum[2], dongzhicommetnum[3], dongzhicommetnum[4], dongzhicommetnum[5], dongzhicommetnum[6], dongzhicommetnum[7], dongzhicommetnum[8], dongzhicommetnum[9]],
                        color: colors[3]
                    }
                }, {
                    y: eval[4],
                    color: colors[4],
                    drilldown: {
                        name: '联想品牌评论关键词',
                        categories: [lenovokeywords[0], lenovokeywords[1], lenovokeywords[2], lenovokeywords[3], lenovokeywords[4], lenovokeywords[5], lenovokeywords[6], lenovokeywords[7], lenovokeywords[8], lenovokeywords[9]],
                        data: [lenovocommetnum[0], lenovocommetnum[1], lenovocommetnum[2], lenovocommetnum[3], lenovocommetnum[4], lenovocommetnum[5], lenovocommetnum[6], lenovocommetnum[7], lenovocommetnum[8], lenovocommetnum[9]],
                        color: colors[4]
                    }
                }, {
                    y: eval[5],
                    color: colors[5],
                    drilldown: {
                        name: 'Dell品牌评论关键词',
                        categories: [dellkeywords[0], dellkeywords[1], dellkeywords[2], dellkeywords[3], dellkeywords[4], dellkeywords[5], dellkeywords[6], dellkeywords[7], dellkeywords[8], dellkeywords[9]],
                        data: [dellcommetnum[0], dellcommetnum[1], dellcommetnum[2], dellcommetnum[3], dellcommetnum[4], dellcommetnum[5], dellcommetnum[6], dellcommetnum[7], dellcommetnum[8], dellcommetnum[9]],
                        color: colors[5]
                    }
                }, {
                    y: eval[6],
                    color: colors[6],
                    drilldown: {
                        name: '苹果品牌评论关键词',
                        categories: [applekeywords[0], applekeywords[1], applekeywords[2], applekeywords[3], applekeywords[4], applekeywords[5], applekeywords[6], applekeywords[7], applekeywords[8], applekeywords[9]],
                        data: [applecommetnum[0], applecommetnum[1], applecommetnum[2], applecommetnum[3], applecommetnum[4], applecommetnum[5], applecommetnum[6], applecommetnum[7], applecommetnum[8], applecommetnum[9]],
                        color: colors[6]
                    }
                }, {
                    y: eval[7],
                    color: colors[7],
                    drilldown: {
                        name: '宏基品牌评论关键词',
                        categories: [acerkeywords[0], acerkeywords[1], acerkeywords[2], acerkeywords[3], acerkeywords[4], acerkeywords[5], acerkeywords[6], acerkeywords[7], acerkeywords[8], acerkeywords[9]],
                        data: [acercommetnum[0], acercommetnum[1], acercommetnum[2], acercommetnum[3], acercommetnum[4], acercommetnum[5], acercommetnum[6], acercommetnum[7], acercommetnum[8], acercommetnum[9]],
                        color: colors[7]
                    }
                }, {
                    y: eval[8],
                    color: colors[8],
                    drilldown: {
                        name: '富士通品牌评论关键词',
                        categories: [fushitongkeywords[0], fushitongkeywords[1], fushitongkeywords[2], fushitongkeywords[3], fushitongkeywords[4], fushitongkeywords[5], fushitongkeywords[6], fushitongkeywords[7], fushitongkeywords[8], fushitongkeywords[9]],
                        data: [fushitongcommetnum[0], fushitongcommetnum[1], fushitongcommetnum[2], fushitongcommetnum[3], fushitongcommetnum[4], fushitongcommetnum[5], fushitongcommetnum[6], fushitongcommetnum[7], fushitongcommetnum[8], fushitongcommetnum[9]],
                        color: colors[8]
                    }
                }, {
                    y: eval[9],
                    color: colors[9],
                    drilldown: {
                        name: '未来人类品牌评论关键词',
                        categories: [weilairenleikeywords[0], weilairenleikeywords[1], weilairenleikeywords[2], weilairenleikeywords[3], weilairenleikeywords[4], weilairenleikeywords[5], weilairenleikeywords[6], weilairenleikeywords[7], weilairenleikeywords[8], weilairenleikeywords[9]],
                        data: [weilairenleicommetnum[0], weilairenleicommetnum[1], weilairenleicommetnum[2], weilairenleicommetnum[3], weilairenleicommetnum[4], weilairenleicommetnum[5], weilairenleicommetnum[6], weilairenleicommetnum[7], weilairenleicommetnum[8], weilairenleicommetnum[9]],
                        color: colors[9]
                    }
                }, {
                    y: eval[10],
                    color: colors[0],
                    drilldown: {
                        name: '华硕品牌评论关键词',
                        categories: [asuskeywords[0], asuskeywords[1], asuskeywords[2], asuskeywords[3], asuskeywords[4], asuskeywords[5], asuskeywords[6], asuskeywords[7], asuskeywords[8], asuskeywords[9]],
                        data: [asuscommetnum[0], asuscommetnum[1], asuscommetnum[2], asuscommetnum[3], asuscommetnum[4], asuscommetnum[5], asuscommetnum[6], asuscommetnum[7], asuscommetnum[8], asuscommetnum[9]],
                        color: colors[0]
                    }
                }, {
                    y: eval[11],
                    color: colors[1],
                    drilldown: {
                        name: '外星人品牌评论关键词',
                        categories: [alienkeywords[0], alienkeywords[1], alienkeywords[2], alienkeywords[3], alienkeywords[4], alienkeywords[5], alienkeywords[6], alienkeywords[7], alienkeywords[8], alienkeywords[9]],
                        data: [aliencommetnum[0], aliencommetnum[1], aliencommetnum[2], aliencommetnum[3], aliencommetnum[4], aliencommetnum[5], aliencommetnum[6], aliencommetnum[7], aliencommetnum[8], aliencommetnum[9]],
                        color: colors[1]
                    }
                }, {
                    y: eval[12],
                    color: colors[2],
                    drilldown: {
                        name: '清华同方品牌评论关键词',
                        categories: [tongfangkeywords[0], tongfangkeywords[1], tongfangkeywords[2], tongfangkeywords[3], tongfangkeywords[4], tongfangkeywords[5], tongfangkeywords[6], tongfangkeywords[7], tongfangkeywords[8], tongfangkeywords[9]],
                        data: [tongfangcommetnum[0], tongfangcommetnum[1], tongfangcommetnum[2], tongfangcommetnum[3], tongfangcommetnum[4], tongfangcommetnum[5], tongfangcommetnum[6], tongfangcommetnum[7], tongfangcommetnum[8], tongfangcommetnum[9]],
                        color: colors[2]
                    }
                }, {
                    y: eval[13],
                    color: colors[3],
                    drilldown: {
                        name: 'Gateway品牌评论关键词',
                        categories: [gatewaykeywords[0], gatewaykeywords[1], gatewaykeywords[2], gatewaykeywords[3], gatewaykeywords[4], gatewaykeywords[5], gatewaykeywords[6], gatewaykeywords[7]],
                        data: [gatewaycommetnum[0], gatewaycommetnum[1], gatewaycommetnum[2], gatewaycommetnum[3], gatewaycommetnum[4], gatewaycommetnum[5], gatewaycommetnum[6], gatewaycommetnum[7]],
                        color: colors[3]
                    }
                }, {
                    y: eval[14],
                    color: colors[4],
                    drilldown: {
                        name: 'HP品牌评论关键词',
                        categories: [hpkeywords[0], hpkeywords[1], hpkeywords[2], hpkeywords[3], hpkeywords[4], hpkeywords[5], hpkeywords[6], hpkeywords[7], hpkeywords[8], hpkeywords[9]],
                        data: [hpcommetnum[0], hpcommetnum[1], hpcommetnum[2], hpcommetnum[3], hpcommetnum[4], hpcommetnum[5], hpcommetnum[6], hpcommetnum[7], hpcommetnum[8], hpcommetnum[9]],
                        color: colors[4]
                    }
                }, {
                    y: eval[15],
                    color: colors[5],
                    drilldown: {
                        name: '雷蛇品牌评论关键词',
                        categories: [leishekeywords[0], leishekeywords[1], leishekeywords[2], leishekeywords[3], leishekeywords[4], leishekeywords[5], leishekeywords[6], leishekeywords[7], leishekeywords[8]],
                        data: [leishecommetnum[0], leishecommetnum[1], leishecommetnum[2], leishecommetnum[3], leishecommetnum[4], leishecommetnum[5], leishecommetnum[6], leishecommetnum[7], leishecommetnum[8]],
                        color: colors[5]
                    }
                }, {
                    y: eval[16],
                    color: colors[6],
                    drilldown: {
                        name: '神舟品牌评论关键词',
                        categories: [shenzhoukeywords[0], shenzhoukeywords[1], shenzhoukeywords[2], shenzhoukeywords[3], shenzhoukeywords[4], shenzhoukeywords[5], shenzhoukeywords[6], shenzhoukeywords[7], shenzhoukeywords[8], shenzhoukeywords[9]],
                        data: [shenzhoucommetnum[0], shenzhoucommetnum[1], shenzhoucommetnum[2], shenzhoucommetnum[3], shenzhoucommetnum[4], shenzhoucommetnum[5], shenzhoucommetnum[6], shenzhoucommetnum[7], shenzhoucommetnum[8], shenzhoucommetnum[9]],
                        color: colors[6]
                    }
                }, {
                    y: eval[17],
                    color: colors[7],
                    drilldown: {
                        name: '七喜品牌评论关键词',
                        categories: [qixikeywords[0], qixikeywords[1], qixikeywords[2], qixikeywords[3], qixikeywords[4], qixikeywords[5], qixikeywords[6], qixikeywords[7], qixikeywords[8], qixikeywords[9]],
                        data: [qixicommetnum[0], qixicommetnum[1], qixicommetnum[2], qixicommetnum[3], qixicommetnum[4], qixicommetnum[5], qixicommetnum[6], qixicommetnum[7], qixicommetnum[8], qixicommetnum[9]],
                        color: colors[7]
                    }
                }, {
                    y: eval[18],
                    color: colors[8],
                    drilldown: {
                        name: '优派品牌评论关键词',
                        categories: [youpaikeywords[0], youpaikeywords[1], youpaikeywords[2], youpaikeywords[3], youpaikeywords[4]],
                        data: [youpaicommetnum[0], youpaicommetnum[1], youpaicommetnum[2], youpaicommetnum[3], youpaicommetnum[4]],
                        color: colors[8]
                    }
                }, {
                    y: eval[19],
                    color: colors[9],
                    drilldown: {
                        name: '其他品牌评论关键词',
                        categories: [elsekeywords[0], elsekeywords[1], elsekeywords[2], elsekeywords[3], elsekeywords[4], elsekeywords[5], elsekeywords[6], elsekeywords[7], elsekeywords[8], elsekeywords[9]],
                        data: [elsecommetnum[0], elsecommetnum[1], elsecommetnum[2], elsecommetnum[3], elsecommetnum[4], elsecommetnum[5], elsecommetnum[6], elsecommetnum[7], elsecommetnum[8], elsecommetnum[9]],
                        color: colors[9]
                    }
                }, {
                    y: eval[20],
                    color: colors[0],
                    drilldown: {
                        name: '微星品牌评论关键词',
                        categories: [weixingkeywords[0], weixingkeywords[1], weixingkeywords[2], weixingkeywords[3], weixingkeywords[4], weixingkeywords[5], weixingkeywords[6], weixingkeywords[7], weixingkeywords[8], weixingkeywords[9]],
                        data: [weixingcommetnum[0], weixingcommetnum[1], weixingcommetnum[2], weixingcommetnum[3], weixingcommetnum[4], weixingcommetnum[5], weixingcommetnum[6], weixingcommetnum[7], weixingcommetnum[8], weixingcommetnum[9]],
                        color: colors[0]
                    }
                }, {
                    y: eval[21],
                    color: colors[1],
                    drilldown: {
                        name: '索尼品牌评论关键词',
                        categories: [sonykeywords[0], sonykeywords[1], sonykeywords[2], sonykeywords[3], sonykeywords[4], sonykeywords[5], sonykeywords[6], sonykeywords[7], sonykeywords[8], sonykeywords[9]],
                        data: [sonycommetnum[0], sonycommetnum[1], sonycommetnum[2], sonycommetnum[3], sonycommetnum[4], sonycommetnum[5], sonycommetnum[6], sonycommetnum[7], sonycommetnum[8], sonycommetnum[9]],
                        color: colors[1]
                    }
                }, {
                    y: eval[22],
                    color: colors[2],
                    drilldown: {
                        name: '技嘉品牌评论关键词',
                        categories: [jijiakeywords[0], jijiakeywords[1], jijiakeywords[2], jijiakeywords[3], jijiakeywords[4], jijiakeywords[5], jijiakeywords[6], jijiakeywords[7], jijiakeywords[8], jijiakeywords[9]],
                        data: [jijiacommetnum[0], jijiacommetnum[1], jijiacommetnum[2], jijiacommetnum[3], jijiacommetnum[4], jijiacommetnum[5], jijiacommetnum[6], jijiacommetnum[7], jijiacommetnum[8], jijiacommetnum[9]],
                        color: colors[2]
                    }
                }];
    
        function setChart(name, categories, data, color) {
      chart.xAxis[0].setCategories(categories, false);
      chart.series[0].remove(false);
      chart.addSeries({
        name: name,
        data: data,
        color: color || 'white'
      }, false);
      chart.redraw();
        }
    
        var chart = $('#container').highcharts({
            chart: {
                type: 'column'
            },
            title: {
                text: 'All Brands Computer Comments Analysis Chart'
            },
            subtitle: {
                text: 'Click the columns to view keywords. Click again to view brands.'
            },
            xAxis: {
                categories: categories
            },
            yAxis: {
                title: {
                    text: ' '
                }
            },
            plotOptions: {
                column: {
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function() {
                                var drilldown = this.drilldown;
                                if (drilldown) { // drill down
                                    setChart(drilldown.name, drilldown.categories, drilldown.data, drilldown.color);
                                } else { // restore
                                    setChart(name, categories, data);
                                }
                            }
                        }
                    },
                    dataLabels: {
                        enabled: true,
                        color: colors[0],
                        style: {
                            fontWeight: 'bold'
                        },
                        formatter: function() {
                            return this.y;
                        }
                    }
                }
            },
            tooltip: {
                formatter: function() {
                    var point = this.point,
                        s = this.x +':<b>'+ this.y;
                    if (point.drilldown) {
                        s += ' percent people think it good</b><br/>';
                        s += 'Click to view '+ point.category +' keywords';
                    } else {
                        s += ' comments</b><br/>';
                        s += 'Click to return to browser brands';
                    }
                    return s;
                }
            },
            series: [{
                name: name,
                data: data,
                color: 'grey'
            }],
            exporting: {
                enabled: false
            }
        })
        .highcharts(); // return chart
    });
    

    </script>

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="navbar-wrapper">
      <div class="container">

        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index.jsp">JD Notebook Analysis</a>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="index.jsp">Home</a></li>
                <li><a href="crawl">Crawl</a></li>
                <li><a href="Analyse">Mining</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown">Analysis <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="ReadData?type=statistics_base_brand_combo">All Brands Computer Sales Analysis Chart</a></li>
                    <li><a href="ReadData?type=comment_analyse">All Brands Computer Comments Analysis Chart</a></li>
                    <li><a href="ReadData?type=sale_share">Sales Percent Chart</a></li>
                    <li><a href="ReadData?type=cpu_analysis_combo">CPU Analysis Chart</a></li>
                    <li><a href="ReadData?type=size_analysis_combo">Size Analysis Chart</a></li>
                    <li><a href="ReadData?type=price_range">Different Price Range Sales Percent</a></li>
                  </ul>
                </li>
                <li><a href="about.jsp">About Us</a></li>
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>



    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
      <!--    <h1>Hello, visitor!</h1>-->
        <p>Here are the analysis result of computer sales in JD.com.</p>
     <!--     <p>Thanks for <a class="btn btn-primary" role="button" href="http://www.highcharts.com/">Highcharts</a></p>-->
      </div>
    </div>
    <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
    
    <div class="container">
      <!-- Example row of columns -->
      <!--
      <div class="row">
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
       </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
        </div>
      </div>
      -->
      <hr>

      <footer>
        <p class="pull-right" style="position:relative;right:30px"><a class="btn btn-lg btn-primary" href="#" role="button" title="back to top">B</a></p>
       <p style="color:#333333;text-align:center;">&copy; The 4th Group of Java Class, School of Software & Microelectronics, Peking University.</p>
      </footer>
    </div> <!-- /container -->



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <script src="dist/js/bootstrap.min.js"></script>
    
  </body>
</html>
