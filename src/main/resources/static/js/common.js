function YTPlayer() {
    var player = $('.ytplayer-wrapper');
    player.each(function () {
        var el = $(this),
            thumbnail = el.find('.yt-thumbnail');

        el.find('.player').YTPlayer();

        el.find('.toggle-play').on('click', function () {
            var btn = $(this);

            if (btn.hasClass('play')) {
                el.find('.player').YTPPause();
                btn.removeClass('play').addClass('pause');
                btn.children('.icons').removeClass('ion-ios-pause-outline').addClass('ion-ios-play-outline');
                if (!el.hasClass('pinned')) {
                    thumbnail.show();
                }
            } else {
                el.find('.player').YTPPlay();
                btn.removeClass('pause').addClass('play pinned');
                btn.children('.icons').removeClass('ion-ios-play-outline').addClass('ion-ios-pause-outline');

                el.addClass('pinned');
                thumbnail.hide();
            }
        });
        el.on('dblclick', function () {
            el.find('.player').YTPFullscreen();
        });
    });
}

function YTPlayerResize() {
    var player = $('.ytplayer-wrapper');
    player.each(function () {
        var el = $(this),
            checkpoint = el.data('checkpoint'),
            videoID = el.data('videoid'),
            windowWidth = window.innerWidth;

        if (el.length !== 0) {
            if (windowWidth < checkpoint) {
                if (el.siblings('.ytplayer-source').length == 0) {
                    el.before('<div class="ytplayer-wrapper ytplayer-source"><iframe src="https://www.youtube.com/embed/' + videoID + '" frameborder="0" allowfullscreen></iframe></div>');
                }
                el.addClass('hide');
            } else {
                if (el.siblings('.ytplayer-source').length !== 0) {
                    el.siblings('.ytplayer-source').remove();
                }
                el.removeClass('hide');
            }
        }
    });

    var player = $("#ytplayer-wrapper"),
        checkpoint = player.data('checkpoint'),
        videoID = player.data('videoid'),
        windowWidth = window.innerWidth;

    if (player.length !== 0) {
        if (windowWidth < checkpoint) {
            if (player.siblings('#ytplayer-source').length == 0) {
                player.before('<div id="ytplayer-source" class="ytplayer-wrapper"><iframe src="https://www.youtube.com/embed/' + videoID + '" frameborder="0" allowfullscreen></iframe></div>');
            }
            player.addClass('hide');
        } else {
            if (player.siblings('#ytplayer-source').length !== 0) {
                $('#ytplayer-source').remove();
            }
            player.removeClass('hide');
        }
    }
}

function synsSlider() {
    var primarySlider = $(".slider01");
    var secondSlider = $(".slider02");
    var flag = false;
    var duration = 300;
    primarySlider.on('changed.owl.carousel', function (e) {
        if (!flag) {
            flag = true;
            secondSlider.trigger('to.owl.carousel', [e.item.index, duration, true]);
            flag = false;
        }
    });
    secondSlider.on('click', '.owl-item', function () {
        primarySlider.trigger('to.owl.carousel', [$(this).index(), duration, true]);

    }).on('changed.owl.carousel', function (e) {
        if (!flag) {
            flag = true;
            primarySlider.trigger('to.owl.carousel', [e.item.index, duration, true]);
            flag = false;
        }
    });
}