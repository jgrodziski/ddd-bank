Version 0.9.1 RC

The Gist
========

<a href="https://github.com/ajkochanowicz/Kickstrap/issues/16">To do for v 1.0 stable</a>

Kickstrap uses the latest version of Twitter's bootstrap (http://twitter.github.com/bootstrap) and adds a layer of extras to create slick web applications with themes, modern html/css standards, an icon font, and progressive enhancement through javascript.

Last updated with Bootstrap v. 2.03

The Extras
==========

**<a href="http://daneden.me/animate/">Animate.css</a>**

+ "Just add water" CSS animations.

**<a href="http://fortawesome.github.com/Font-Awesome/#">Font Awesome</a> + <a href="http://keyamoon.com/icomoon/">IcoMoon</a>**

+ Turns glyphicons into an icon font to use a variety of sizes and colors. Also adds a bunch of new icons from FontAwesome and IcoMoon.

**<a href="http://html5boilerplate.com/">HTML5 Boilerplate</a> Goodies**

Uses sample files and resources gathered and created from HTML5 Boilerplate for making great HTML5 pages. Bootstrap Extra includes a sample file ready to go for a new Bootstrap HTML5 Page.

+ Normalized, jQueryized, Doctypized html starter files.
+ Modernizr js loaded and ready to go in starter html files.
+ Ready for Google Analytics
+ Optional Google Chrome Frame prompt for users of older browsers
+ Too much to mention here. More information at <a href="http://html5boilerplate.com/">H5BP Homepage</a>

**New javascript plugins**

+ <a href="http://harvesthq.github.com/chosen/">Chosen</a>, a jQuery-powered library to stylize &lt;select&gt; boxes. (See sample.html)
+ <a href="http://archive.plugins.jquery.com/project/jGrowl">jGrowl</a>, a Growl-like notification system for websites.

**Themes**

+ Easily switch to different color schemes.
+ Support for <a href="http://bootswatch.com/">Bootswatch</a> themes. Easily switch between predefined theme packages.

**<a href="http://adamkochanowicz.com/oneline.html">One Line CSS Grid</a>**

+ OLCG is just a 98 byte code snippet to quickly halve or third anything.
+ (.oh = one half, ot = one third, tt = two thirds.)
+ Check out the docs to see how much this little piece of code can do.

**Some IE6 Compatibility**

+ I know, I know. But there are still some sites with specialized circles of clients whose users base is significantly IE6 reliant.
+ Thanks to <a href="https://github.com/empowering-communities/Bootstrap-IE6">Sharry Stowell's IE6 css/js for Bootstrap</a>, Kickstrap will display significantly better in IE6 than plain Bootstrap. 
+ Only IE7- users will download the small, additional css and js.

Quick Start
===========

Install
-------

+ If you're starting from scratch, simply download this repository and start working in the index.html or sample_index.html document.
+ If you already have a Bootstrap installation running, drop the /extras folder into your Bootstrap root. Drag the sample_index.html file in /extras to your Bootstrap root and /extras/css/bootstrap(.min).css wherever you have your existing bootstrap.css file. It should be linked and ready to go.
(If you already have HTML files you want to use, see "Advanced Setup" below.

Pick Theme
----------

*LESS compiler required, <a href="https://github.com/ajkochanowicz/Kickstrap/wiki/Windows">Windows users should do this.</a>

1. Open /extras/themes/settings.less and uncomment the @import line (remove the //s) of the theme you want to use.
2. Compile.

Advanced Setup
==============

In the future, I plan to have a customized download replace the need for "Advanced Setup".

Install
-------

1. If you already have html (or php, aspx...) files you want to use, drop the /extras folder in your Bootstrap root. Paste this into the head of every page you want to use Kickstrap:
<pre>&lt;meta name=&quot;viewport&quot; content=&quot;width=device-width, initial-scale=1.0, maximum-scale=1, user-scalable=no&quot;&gt;
&lt;link rel=&quot;stylesheet&quot; href=&quot;css/bootstrap.css&quot;&gt;
&lt;script src=&quot;extras/html5bp/js/libs/modernizr-2.5.3.min.js&quot;&gt;&lt;/script&gt;</pre>
(Assuming this file is in the Bootstrap root directory. Adjust accordingly.)
2. Add the following just before the ending &lt;body&gt; tag:
<pre>&lt;script src=&quot;//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js&quot;&gt;&lt;/script&gt;
&lt;script&gt;window.jQuery || document.write('&lt;script src=&quot;extras/h5bp/js/libs/jquery-1.7.1.min.js&quot;&gt;&lt;\/script&gt;')&lt;/script&gt;
&lt;script type=&quot;text/javascript&quot; src=&quot;extras/chosen/chosen.jquery.min.js&quot;&gt;&lt;/script&gt; 
&lt;script type=&quot;text/javascript&quot; src=&quot;js/bootstrap.min.js&quot;&gt;&lt;/script&gt;
&lt;script&gt;
  var _gaq=[['_setAccount','UA-XXXXX-X'],['_trackPageview']];
  (function(d,t){var g=d.createElement(t),s=d.getElementsByTagName(t)[0];
  g.src=('https:'==location.protocol?'//ssl':'//www')+'.google-analytics.com/ga.js';
  s.parentNode.insertBefore(g,s)}(document,'script'));
&lt;/script&gt;</pre>
(Assuming this file is in your root bootstrap directory. Adjust accordingly.)
3. Add this to the end of the /less/bootstrap.less file:
<code>@import "../extras/settings/overrides.less";<code>
4. Choose your theme in /extras/themes/settings.less (uncomment the @import line you want to use) and compile.

Optional: If you're using your own existing Bootstrap installation and really don't want to replace bootstrap.css (say you've customized it),
remember to include the chosen library with the following lines of code near your ending body tag:

<pre>&lt;link type=&quot;text/css&quot; rel=&quot;stylesheet&quot; href=&quot;extras/css/chosen.min.css&quot; /&gt;
&lt;script src=&quot;//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js&quot;&gt;&lt;/script&gt;
&lt;script type=&quot;text/javascript&quot;&gt; $(&quot;.chzn-select&quot;).chosen(); $(&quot;.chzn-select-deselect&quot;).chosen({allow_single_deselect:true}); &lt;/script&gt;</pre>

Pick Theme
----------

If using the included index.html file, you can follow the instructions in "Quick Setup" above.

Authors
-------

**Mark Otto** (Bootstrap)

+ http://twitter.com/mdo
+ http://github.com/markdotto

**Jacob Thornton** (Bootstrap)

+ http://twitter.com/fat
+ http://github.com/fat

**Adam Kochanowicz** (Kickstrap)

+ http://twitter.com/yourwebsitesUX

Copyright and license
=====================

Bootstrap: Copyright 2012 Twitter, Inc.
---------------------------------------

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Font Awesome
------------

The Font Awesome webfont, CSS, and LESS files are licensed under CC BY 3.0. A mention of Font Awesome - http://fortawesome.github.com/Font-Awesome in human-readable source code is considered acceptable attribution (most common on the web). If human readable source code is not available to the end user, a mention in an 'About' or 'Credits' screen is considered acceptable (most common in desktop or mobile software).

Chosen, a Select Box Enhancer for jQuery and Protoype
-----------------------------------------------------

by Patrick Filler for Harvest
Available for use under the MIT License

Copyright (c) 2011 by Harvest

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

HTML5 Boilerplate
-----------------

+ http://html5boilerplate.com/html5boilerplate-site/built/en_US/docs/license/

jQuery
------

+ http://jquery.org/license/

Modernizr
---------

+ http://www.modernizr.com/license/

Normalize.css
-------------

+ https://github.com/necolas/normalize.css/blob/master/README.md

<a href="https://github.com/daneden/animate.css">Animate.css</a>
-----------

+ Animate.css is licensed under the ☺ license. (http://licence.visualidiot.com/)