(function () {
   'use strict';   // this function is strict...

   	var elara = {
   		plugins: [
   			'js/lib/sudoslider.js',
   			'js/lib/videobg.js',
   			'js/lib/instafeed.js',
            'js/lib/sticky.js',
            'js/lib/knob.js',
            'js/lib/isinviewport.js',
            'js/lib/parsley.js',
            'js/lib/countdown.js',
            'js/lib/texteffect.js',
            'js/lib/fitvids.js',
            'js/lib/swipebox.js',
            'js/lib/imagesloaded.js',
            'js/lib/masonry.js',
            'js/lib/isotope.js',
            'js/lib/classie.js',
            'js/lib/animonscroll.js',
            'js/lib/jquery.stellar.js',
            'js/lib/smooth.js',
            'js/lib/rs/jquery.themepunch.plugins.min.js',
   			'js/lib/rs/jquery.themepunch.revolution.min.js',
   		],

   		settings: {
   			homeSlider: {
   				delay: 9000,
               startwidth: 1170,
               startheight: 500,
               hideThumbs: 10,
               responsive: true,
               navigationType: 'none',
               fullWidth: 'on',

   			},
            homeSliderTwo: {
               responsive: true,
               controlsShow: false,
               customLink: '.home-slider-nav > li',
               vertical: true,
               auto: true,
               effect: "pushOutRight, sliceRandom,boxRainGrow",
               speed: 1500,
               pause: 7000,
               beforeAnimation: function(e) {

                  //Home Slider two icon
                  var slideIcon = $('.home-slider-nav > li').eq(e-1).data('icon');
                  $('#icon-slider').removeClass();
                  setTimeout(
                    function() 
                       {
                     $('#icon-slider').addClass('show-icon ico-'+slideIcon);
                  }, 500);
               },
               initCallback: function () {
                   setTimeout(function() {
                        $('.slider-up-layer').css('opacity', 1);                     
                   }, 500);
               },
            },
            homeSliderThree: {
               delay: 9000,
               startwidth: 1170,
               startheight: 500,
               hideThumbs: 0,
               responsive: true,
               navigationType: 'bullet',
               fullWidth: 'off',
               hideTimerBar: 'on',
               navigationStyle: 'round-old',

            },
   			homeSliderText: {
   				controlsShow: false,
   				vertical: true,
   				speed: 1500,
   				pause: 7000,
   				customLink: '.home-slider-nav > li',
   				auto: true,
               updateBefore: true,
               responsive: true,
   			},

            blogSlider: {
               responsive: true,
               controlsShow: false,
               vertical: false,
               speed: 1500,
               pause: 7000,
               customLink: '.blog-slider-nav > li',
               auto: false,
               updateBefore: true,
               afterAnimation: function (index) { $('.blog-slides > li > figure > figcaption')
                                                   .eq(index-1)
                                                   .addClass('show-caption'); },
               beforeAnimation: function () { $('.blog-slides > li > figure > figcaption').removeClass('show-caption');},
               initCallback: function () { $('.blog-slides > li > figure > figcaption')
                                                   .eq(0)
                                                   .addClass('show-caption');},
            },

            magicSlider: {
               controlsShow: false,
               vertical: true,
               speed: 1500,
               effect: "fadeOutIn",
               customLink: '.show-theme > li a, #magic-slider',
               responsive: true,
               updateBefore: true,
               continuous: true,
            },

            gallerySlider: {
               controlsShow: false,
               vertical: true,
               speed: 1000,
               effect: "fadeOutIn",
               customLink: '.gallery-slider-nav ul > li',
               responsive: true,
               updateBefore: true,
               continuous: true,
            },

            membersSlider: {
               controlsShow: false,
               vertical: false,
               speed: 1500,
               customLink: '.nav-header > li a',
               responsive: true,
               slideCount: 4,
               continuous: true
            },

            blogCardsSlider: {
               controlsShow: false,
               vertical: false,
               speed: 1500,
               customLink: '.nav-header > li a',
               responsive: true,
               slideCount: 3,
               continuous: true
            },

            partnerSlider: {
               controlsShow: false,
               vertical: false,
               speed: 1500,
               customLink: '.members-nav > li a',
               responsive: true,
               slideCount: 5,
               continuous: true,
               moveCount: 5,
            },

            quoteSlider: {
               controlsShow: false,
               vertical: true,
               speed: 1500,
               effect: "pushOutUp",
               customLink: '.quote-nav > li',
               responsive: true,
               continuous: true,
               updateBefore: true,
            },


            carouselFeatures: {
               controlsShow: false,
               vertical: false,
               speed: 1500,
               customLink: '#features-nav-carousel a',
               responsive: true,
               slideCount: 4,
               continuous: true,
               moveCount: 1,
            },

            carouselBlog: {
               controlsShow: false,
               vertical: false,
               speed: 1500,
               customLink: '#blog-nav-carousel a',
               responsive: true,
               slideCount: 1,
               continuous: true,
               moveCount: 1,
            },

            carouselPosts: {
               controlsShow: false,
               vertical: false,
               speed: 1500,
               customLink: '#posts-nav-carousel a',
               responsive: true,
               slideCount: 3,
               continuous: true,
               moveCount: 1,
            },

            testimonialSlider: {
               controlsShow: false,
               vertical: false,
               speed: 1500,
               effect: "slide",
               customLink: '.testimonial-nav > li > a',
               responsive: true,
               continuous: true,
               updateBefore: true,
            },

            portfolioSlider: {
               controlsShow: false,
               vertical: true,
               speed: 500,
               customLink: '.filter-portfolio > li > a',
               responsive: true,
               controlsFade: false,
               updateBefore: true,
               continuous: true,
            },

            sidebarSlider: {
               controlsShow: false,
               vertical: false,
               speed: 500,
               customLink: '.slider-nav > a',
               responsive: true,
               controlsFade: false,
               updateBefore: true,
            },

            tabsSlider: {
               controlsShow: false,
               vertical: false,
               speed: 500,
               customLink: '.tabs-nav > li',
               responsive: true,
               controlsFade: false,
               updateBefore: true,
            },

            ProductTabsSlider: {
               controlsShow: false,
               vertical: false,
               speed: 500,
               customLink: '.tab-nav > li > a',
               responsive: true,
               controlsFade: false,
               updateBefore: true,
            },

   			instagramFeed: {
   		        get: 'tagged',
   		        tagName: 'nature',
   		        limit: 6,
   		        clientId: '632fb01c8c0d43d7b63da809d0b6a662',
   		        template: ' <li class="col-xs-4 col-sm-2 col-md-4"><figure class="square-area"><a href="{{link}}" target="blank"><img src="{{image}}" /></a></figure></li>'
   		    },

            featuresProgress: {
               fgColor: '#58B1C2',
               bgColor: '#e9e9e9',
               readOnly: true,
               thickness: 0.05,
               linecap: 'round',
               inputColor: '#505050',
               font: "Lato, sans-serif",
               fontWeight: "400",
               format: function(e) {
                  return e+"%";
               }
            },

            countdown: {
               fgColor: '#58B1C2',
               bgColor: '#e9e9e9',
               readOnly: true,
               thickness: 0.05,
               linecap: 'round',
               inputColor: '#505050',
               font: "Lato, sans-serif",
               fontWeight: "400",
               format: function(e) {
                  return e;
               }
            },

            textEffetct: {
               reverse: false,
               fps: 20
            },

            imageZoom: {
               useCSS : true, // false will force the use of jQuery for animations
               initialIndexOnArray: 0, // which image index to init when a array is passed
               hideBarsDelay : 3000, // 0 to always show caption and action bar
               videoMaxWidth : 1140, // videos max width
               beforeOpen: function(){} , // called before opening
               afterClose: function(){} // called after closing
            },

            testimonialsGrid: {
               itemSelector: 'li',
               "columnWidth": 'li'
            },

            scrollLoad: {
               minDuration : 0.4,
               maxDuration : 0.7,
               viewportFactor : 0.1
            }

   		},

         lastCall: function() {
            window.onload = function() {
               var d = document.getElementById("go-home");
               setTimeout(function() {
                  d.className = d.className + " loadded";                  
               }, 1000);
            }
         },

   		loadPlugins: function() {

			Modernizr.load([
			    {
			        load: [
			                'http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js',
			        ],

			        complete: function () {
			          	if ( !window.jQuery ) {
			                Modernizr.load('js/lib/jquery.js');
			          	}

			          	var settings = elara.settings,
		          		    run = elara.mainMethods,
			          		 scripts = [];

			          	$.each(elara.plugins,function(index,script){
			            	scripts[index] = $.getScript(script);
			          	});
				        $.when.apply($,scripts).done(function(e){
                        // Run Sliders
                        run.revSlider($('#home-slider'), settings.homeSlider);
                        run.revSlider($('#home-slider-three'), settings.homeSliderThree);
				            run.sliderSudo($('#home-slider-two'), settings.homeSliderTwo);
                        run.sliderSudo($("#home-slider-text"), settings.homeSliderText);
                        run.sliderSudo($("#magic-slider, #about-slider"), settings.magicSlider);
                        run.sliderSudo($(".main-gallery-slider"), settings.gallerySlider);
                        run.sliderSudo($("#slider-quote"), settings.quoteSlider);

                        var carouselFeatures = $("#carousel-features").sudoSlider(settings.carouselFeatures);

                        if($("#carousel-features").length) {
                           if($(window).width() < 992 && $(window).width() > 750) {
                              carouselFeatures.setOption('slideCount', 2);
                           }else if ($(window).width() < 750) {
                              carouselFeatures.setOption('slideCount', 1);
                           }

                           $(window).resize(function() {
                              if($(window).width() < 992 && $(window).width() > 750) {
                                 carouselFeatures.setOption('slideCount', 2);
                              }else if ($(window).width() < 750) {
                                 carouselFeatures.setOption('slideCount', 1);
                              } else {
                                 carouselFeatures.setOption('slideCount', 4);
                              }
                           });
                        }

                        run.sliderSudo($("#carousel-blog"), settings.carouselBlog);

                        var carouselPosts = $("#carousel-posts").sudoSlider(settings.carouselPosts);

                        if($("#carousel-posts").length) {
                           if($(window).width() < 992 && $(window).width() > 750) {
                              carouselPosts.setOption('slideCount', 3);
                           }else if ($(window).width() < 750) {
                              carouselPosts.setOption('slideCount', 1);
                           }

                           $(window).resize(function() {
                              if($(window).width() < 992 && $(window).width() > 750) {
                                 carouselPosts.setOption('slideCount', 3);
                              }else if ($(window).width() < 750) {
                                 carouselPosts.setOption('slideCount', 1);
                              } else {
                                 carouselPosts.setOption('slideCount', 3);
                              }
                           });
                        }

                        var memberSlider = $(".members-slider").sudoSlider(settings.membersSlider);

                        if($(".members-slider").length) {
                           if($(window).width() < 992 && $(window).width() > 750) {
                              memberSlider.setOption('slideCount', 3);
                           }else if ($(window).width() < 750) {
                              memberSlider.setOption('slideCount', 1);
                           }

                           $(window).resize(function() {
                              if($(window).width() < 992 && $(window).width() > 750) {
                                 memberSlider.setOption('slideCount', 3);
                              }else if ($(window).width() < 750) {
                                 memberSlider.setOption('slideCount', 1);
                              } else {
                                 memberSlider.setOption('slideCount', 4);
                              }
                           });
                        }

                        var blogCardsSlider = $(".blog-cards-slider").sudoSlider(settings.blogCardsSlider);

                        if($(".blog-cards-slider").length) {
                           if($(window).width() < 992 && $(window).width() > 765) {
                              blogCardsSlider.setOption('slideCount', 2);
                           }else if ($(window).width() < 765) {
                              blogCardsSlider.setOption('slideCount', 1);
                           }

                           $(window).resize(function() {
                              if($(window).width() < 992 && $(window).width() > 765) {
                                 blogCardsSlider.setOption('slideCount', 2);
                              }else if ($(window).width() < 765) {
                                 blogCardsSlider.setOption('slideCount', 1);
                              } else {
                                 blogCardsSlider.setOption('slideCount', 3);
                              }
                           });
                        }

                        var partSlider = $(".partner-slider").sudoSlider(settings.partnerSlider);

                        if($(".partner-slider").length) {
                           if($(window).width() < 992 && $(window).width() > 750) {
                              partSlider.setOption('slideCount', 4);
                              partSlider.setOption('moveCount', 4);
                           }else if ($(window).width() < 750) {
                              partSlider.setOption('slideCount', 1);
                              partSlider.setOption('moveCount', 1);
                           }

                           $(window).resize(function() {
                              if($(window).width() < 992 && $(window).width() > 750) {
                                 partSlider.setOption('slideCount', 4);
                              partSlider.setOption('moveCount', 4);
                              }else if ($(window).width() < 750) {
                                 partSlider.setOption('slideCount', 1);
                              partSlider.setOption('moveCount', 1);
                              } else {
                                 partSlider.setOption('slideCount', 5);
                                 partSlider.setOption('moveCount', 5);
                              }
                           });
                        }

                        run.sliderSudo($(".portfolio-slider"), settings.portfolioSlider);
                        run.sliderSudo($("#sidebar-slider"), settings.sidebarSlider);
                        run.sliderSudo($("#blog-slider"), settings.blogSlider);
                        run.sliderSudo($("#testimonial-slider"), settings.testimonialSlider);
                        run.sliderSudo($(".tabs-content"), settings.tabsSlider);
				            run.sliderSudo($(".tab-body>div"), settings.ProductTabsSlider);

                        //Run instagram Feed
				            run.instagramFeed(settings.instagramFeed);
                        // Initialize sticky menu
                        run.stickyMenu($(".general-header"));
                        // Form Validation
                        run.formValidation($("#contact-form"));
                        run.formValidation($("#comment-form"));
                        // Google Map
                        run.googleMap();

                        run.countDown();

                        run.fitvids();

                        run.zoomImage($('.zoom-img'),settings.imageZoom);

                        //run.masonryGrid($('#testimonials-grid'),settings.testimonialsGrid);

                        run.scrollAnim('testimonials-grid', settings.scrollLoad);

                        run.textEffect($('#text-effect'),settings.textEffect);

                        run.radialProgress($(".countdown > li input[type=text]"), settings.countdown);

				            run.radialProgress($(".statistic-element > li input[type=text]"), settings.featuresProgress);

                        // Portfolio Filters

                        run.portfolioFilter($('#portfolio-filter > li > a'));

                        run.infiniteScroll($('.infinite-scroll'));

                        // Shop image product switcher

                        run.shopProductView($('.fancy-product-view figcaption ul li a'));
                        run.shopProductView($('.preview-thumb li a'));

                        // Custom Slect
                        run.customSelect($('.fancy-select'));

                        // Custom number picker
                        run.customNumberPic($('.fancy-number-pick'));

                        // Fast facts

                        //run.fastFacts($('.counter-item h1'));

                        // Parallax effect
                        //$(window).stellar();

                        // Mobile menu

                        run.mobileMenu($('.mobile-menu'));

                        // Done Loading page
                        setTimeout(function() {
                           $('.logo-link > i').removeClass();
                           $('.logo-link > i').addClass('ico-546');
                        }, 1000);

                        var s = 0;

                        $(window).scroll(function() {
                           if($('.statistic-element').length) {
                              var checkFocus = $('.statistic-element').isInViewport();                              
                           }

                           if(checkFocus == true) { s++;}

                           if(s === 1) {
                              $(".statistic-element > li input[type=text]").each(function() {
                                 var defaultVal = $(this).val().slice(0,-1),
                                     i = 0,
                                     target = $(this);

                                    setInterval(function() {
                                       if(defaultVal >= i) {
                                          target.val(i).trigger('change');
                                          i++;
                                       }
                                    }, 30);
                              });
                           }
                        });
                       


				        });
			        }
			    }
			]);

   		},

   		mainMethods: {
   			sliderSudo: function(target, settings) {
   				return target.sudoSlider(settings);
   			},
   			videoSlider: function(target, settings) {
   				target.videoBG(settings);
   			},
   			instagramFeed: function(settings) {
               if($('#instafeed').length) {
   				   var feed = new Instafeed(settings);
                  feed.run();
                  
               }
   			},
   			stickyMenu: function(target) {
   				target.sticky({topSpacing:0});
   			},
            radialProgress: function(target, settings) {
               target.knob(settings);
            },
            formValidation: function(target) {
               if(target.length) {
                  target.parsley();
               }
            },
            countDown: function() {
               var clock = document.getElementById("timerText");  
               var targetDate = new Date(2015, 0, 1);
               var nowDate = new Date(2014, 3, 10);

               var holder = $(".countdown > li input[type=text]"),
                   daysHolder = holder.eq(0),
                   hoursHolder = holder.eq(1),
                   minutesHolder = holder.eq(2),
                   secondsHolder = holder.eq(3);

               setInterval(function(){
                  var days = countdown(targetDate, null, countdown.DAYS|countdown.HOURS|countdown.MINUTES|countdown.SECONDS).days;
                  var hours = countdown(targetDate, null, countdown.DAYS|countdown.HOURS|countdown.MINUTES|countdown.SECONDS).hours;
                  var minutes = countdown(targetDate, null, countdown.DAYS|countdown.HOURS|countdown.MINUTES|countdown.SECONDS).minutes;
                  var seconds = countdown(targetDate, null, countdown.DAYS|countdown.HOURS|countdown.MINUTES|countdown.SECONDS).seconds;
                  daysHolder.val(days).trigger('change');
                  hoursHolder.val(hours).trigger('change');
                  minutesHolder.val(minutes).trigger('change');
                  secondsHolder.val(seconds).trigger('change');

               }, 1000); 
            },
            textEffect: function(target, settings) {
               if(target.length) {
                  target.height(target.height());
                  $(window).resize(function() {
                     target.height(target.height());
                  });
                  setTimeout(function() {
                     target.show();
                     target.textEffect(settings);
                  }, 1000);
               }
            },
            fitvids: function() {
               var video = $('noscript').text();
               var parent = $('noscript').parent();
               parent.append(video);

              $('body').fitVids({ customSelector: "iframe[src^='//player.vimeo.com'], iframe[src^='//youtube.com']"});
            },
            zoomImage: function(target, settings) {
               target.swipebox(settings);
            },

            scrollAnim: function(target, settings) {
               if(document.getElementById( target )){
                  new AnimOnScroll( document.getElementById( target ), settings );                  
               }
            },

            revSlider: function(target, settings) {
               if(target.length){
                  target.revolution(settings);
               }
            },

            masonryLayout: function(target, settings) {
               if(target.length){
                  target.imagesLoaded( function() {
                     target.isotope(settings);
                  });
               }
            },

            portfolioFilter: function(target) {
               var masonry = this.masonryLayout;
               if(target.length){
                  var filterLinks = target,
                      filterTags,
                      filterItems = $('.mosaic-view > li'),
                      itemWidth = filterItems.width(),
                      intemHeight = filterItems.height(),
                      label = $('.portfolio-filter label');

                  masonry($('.mosaic-view'), {filter: 'li'});

                  if(label.length) {
                     $('html').click(function() {
                        $('#portfolio-filter-helper').prop('checked', false);
                     });

                     $('.portfolio-filter').click(function(event){
                         event.stopPropagation();
                     });
                  }

                  filterLinks.click(function(e) {
                     e.preventDefault();

                     filterTags = $(this).parent().data('filter-tags');

                     if(label.length) {
                        label.text($(this).text());
                     }

                     if(filterTags === undefined) {
                        if(filterItems.length) {
                           filterItems.removeClass('filtred-item');
                           masonry($('.mosaic-view'), {filter: 'li'});
                        }

                     } else {

                        if(filterItems.length) {
                           filterItems.removeClass('filtred-item');
                           filterItems.each(function() {
                              if($(this).data('portfolio-items').match(filterTags)) {
                                 $(this).addClass('filtred-item');
                              }
                           });
                           masonry($('.mosaic-view'), {filter: '.filtred-item'});
                        }
                     }


                     filterLinks.removeClass('current');
                     $(this).addClass('current');
                  });

               }
            },

            infiniteScroll: function(target) {
               var items = target.children(),
                   itemsLenght = items.length,
                   limit = target.data('scroll-limit'),
                   s, checkFocus,
                   limitCount = limit,
                   masonry = this.masonryLayout;

               items.each(function(index) {
                  if(index < limit) {
                     items.eq(index).addClass('focused-item')
                  }
               });
               $(window).scroll(function() {

                  if(items.eq(limitCount-1).length) {
                     var checkFocus = items.eq(limitCount-1).isInViewport();

                  }

                  if(checkFocus === true) {s++;}

                  if(checkFocus === true) {
                     items.removeClass('focused-item');
                     items.each(function(index) {
                        if(index <= limitCount) {
                           items.eq(index).addClass('focused-item');
                        }
                     });

                     if($('.mosaic-view').length) {
                        //masonry($('.mosaic-view'), {filter: '.focused-item'});                     
                     }
                     limitCount = limitCount + limit;
                  }
               });
            },

            shopProductView: function(target) {
               if(target.length) {
                  var productImg,
                      imgSrc, previewHolder;

                  target.click(function(e) {
                     e.preventDefault();
                     productImg = $(this).parent().parent().parent().parent().parent().children('a').find('img');
                     previewHolder = $('.preview-holder > img');

                     if(productImg.length){
                        $(this).parent().parent().parent().find('a').removeClass('current-thumb');
                        imgSrc = $(this).find('img').attr('src');
                        productImg.attr('src', imgSrc);
                        $(this).addClass('current-thumb');                        
                     }

                     if(previewHolder.length){
                        target.removeClass('current-thumb');
                        imgSrc = $(this).find('img').attr('src');
                        previewHolder.attr('src', imgSrc);
                        previewHolder.parent().attr('href', imgSrc);
                        $(this).addClass('current-thumb');
                     }
                  });
               }

            },

            customSelect: function(target) {
               if(target.length) {
                     $('html').click(function() {
                        target.find('input[type=checkbox]').prop('checked', false);
                     });

                     target.click(function(event){
                         event.stopPropagation();
                     });

                     target.find('a').click(function(e){
                        e.preventDefault();

                        target.find('a').removeClass('active');

                        if(target.find('label').length) {
                           target.find('label span').text($(this).text());
                        }

                        $(this).addClass('active');
                     });
                  }
            },

            customNumberPic: function(target) {
               if(target.length) {
                  var indexBtn, inputVal, newVal = 1;
                  target.find('span').click(function(e) {
                     e.preventDefault();
                     indexBtn = target.find('span').index(this);
                     inputVal = parseInt(target.find('input').val());

                     if(!inputVal) {
                        inputVal = 0;
                     }

                     if(indexBtn === 0 && inputVal > 1) {
                        newVal = inputVal - 1;
                     } 

                     if(indexBtn === 1) {
                        newVal = inputVal + 1;
                     }

                     target.find('input').val(newVal);

                  });
               }
            },

            fastFacts: function(target) {
               if (target.length) {
                  var factVal = [], factRot = [],
                      s = 1, item, countfacts;

                  target.each(function(i) {
                     item = $(this);
                     factVal[i] = parseInt($(this).text());
                     
                     countfacts = setInterval(function() {

                        s++;

                        if(factVal[i] < s || s === 1000) {
                           clearInterval(countfacts[i]);
                           target.eq(i).text(factVal[i]);

                           if(s === 1000) {
                              s = 0;                             
                           }
                        } else {
                           target.eq(i).text(factRot[i] + s);                           
                        }
                     }, 5);
                  });
               };
            },

            mobileMenu: function(target) {
               if(target.length) {
                  var i = 0, z = 0;

                  target.click(function(e) {
                     e.preventDefault();
                     $('.sticky-wrapper').toggleClass('mobile-active');

                     $('.general-nav').toggleClass('menu-side');

                     i++;

                     if(i === 1) {
                        $(this).find('i').removeClass().addClass('ico-877');
                     } else {
                        i = 0;
                        $(this).find('i').removeClass().addClass('ico-688');
                     }

                  });
                     
                  

                  $( "body" ).on('click', '.menu-side > ul li  a', function(e) {

                     $(this).toggleClass('item-picked');

                     if($(this).next('ul').length) {
                        z++;

                        if(z === 1) {
                           e.preventDefault();
                        }

                        $(this).next('ul').toggle();                        
                     }
                  });


               }
            },

            googleMap: function() {
               if($('#map-container').length) {
                  var myLatlng = new google.maps.LatLng(44.2661906,-68.5691898);
                  var myOptions = {
                      zoom: 16,
                      center: myLatlng,
                      disableDefaultUI: true,
                      panControl: true,
                      zoomControl: true,
                      scrollwheel: false,
                      zoomControlOptions: {
                          style: google.maps.ZoomControlStyle.DEFAULT
                      },

                      mapTypeControl: true,
                      mapTypeControlOptions: {
                          style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR
                      },
                      streetViewControl: true,
                      mapTypeId: google.maps.MapTypeId.ROADMAP,

                     };
               
                  var map = new google.maps.Map(document.getElementById("map-container"), myOptions);
                  var marker = new google.maps.Marker({
                      position: myLatlng,
                      map: map,
                      icon: "img/pin.png",
                      animation: google.maps.Animation.DROP,
                      title: "test",
                      labelContent: "Elara",
                  });

                  var contentString = '<div class="map-window"><span class="cursive-font">Elara</span></div>';

                  var infowindow = new google.maps.InfoWindow({
                     content: contentString
                  });  
                  google.maps.event.addListener(marker, 'click', function() {
                     infowindow.open(map,marker);
                  });            
               }
            }

   		},
   	};


   	elara.loadPlugins();
      elara.lastCall();

}());
