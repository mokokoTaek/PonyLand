const config = {
    type: Phaser.AUTO,
    backgroundColor: '#ffffff', //배경색
    scene: [GameScene3],
    scale: {
        mode: Phaser.Scale.FIT, //동적이미지
        width: 600, //게임 화면 사이즈
        height: 400,
        autoCenter: Phaser.Scale.CENTER_BOTH // 화면 크기에 따라서 정중앙에 위치하게 만들기
    },

    //충돌 체크 옵션
    physics: {
        default: 'arcade',
        arcade: {
            //debug: true,
        }
    },
    pixelArt: true,
};

const GAME = new Phaser.Game(config);
const WIDTH = GAME.config.width;
const HEIGHT = GAME.config.height;