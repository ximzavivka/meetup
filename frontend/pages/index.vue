<template>
  <v-row justify="center" align="center">
    <v-col cols="12" sm="8" md="6">
      <v-card class="logo py-4 d-flex justify-center">
        <v-carousel>
          <v-carousel-item
            v-for="(item,i) in items"
            :key="i"
            :src="`/${item.url}`"
            reverse-transition="fade-transition"
            transition="fade-transition"
          ></v-carousel-item>
        </v-carousel>
      </v-card>

    </v-col>
    <v-col cols="10" class="justify-center">
      <blockquote class="blockquote text-center">
        &#8220;Это моя первая страница на Vue&#8221;
      </blockquote>
    </v-col>

    <div ref="cursorBalloon" class="balloon">
      <img src="netology.png"/>
    </div>
  </v-row>
</template>

<script>
export default {
  name: 'IndexPage',
  data() {
    return {
      items: [],
    }
  },
  mounted() {
    this.loadImages();
    const balloon = this.$refs.cursorBalloon;

    window.onmousemove = (e) => {
      if (balloon) {
        let x = e.clientX;
        let y = e.clientY;
        if (x > 0 && y > 0) {
          balloon.style.top = y + 25 + 'px';
          balloon.style.left = x + 25 + 'px';
          balloon.style.visibility = 'visible'
        } else {
          balloon.style.visibility = 'hidden'
        }
      }
    }

    window.onmouseout = (e) => {
      balloon.style.visibility = 'hidden'
    }

  },
  methods: {
    async loadImages() {
      this.items = await this.$axios.$get('http://localhost:9858/demo/images');
    }
  }
}
</script>

<style lang="css">
body {
  cursor: -webkit-image-set(url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAC4AAAAtCAQAAAB7JJESAAAC0UlEQVR42u2WP0wTYRiHn7vrfXe99sq1cK2FlhYpFIr4J2h0MkHjoJOJ6aiyueLqVDeNm4lxwASimzHGxVkXJxeVxcShJsaJRIkLA8JnvqsSaqB3bXXjt3V57u1zv/f7Dg5ykIP8p2ggF2VTvpKLsoymfv9D+Oa83Mn2a7mwMYYm+39IgDDWTsq/oh4h0/3idQzEk/z2utwj2y/kQqBJ6822Tgw7k9p4KffLd7ksLytNsge4SYLBN1dk5zS3VjbnN+nuXxhYuPhXj/z8IcPTlMub81HxWkOviSEXn/LXFRk1za2bDT1clIZeE34Sn9Lza7KLbN1W+JDRG/qcmXcYZFRMRRKzU1XM8Om1uoGN5wxT+fI4OvzbjYpFDD1siQxEJkXWHnu6EBW9ds/zcDBD4MEaBWW0R5mOJubzfYpJHxerbtRDux6IYZiJTw/C0R8fMk2Z7JBbtomFr5aOwFVinl0PQ68ucYIpSsksbsXCCGuM1tBpNaYoptffdkK/f8QpMcsEI2RIzEVwjmw1ZoC8VekkRqE5Zk1SIpdJYROLsqsaesUacpM+Y7cuhKCrdimRY6DVlWiHmT5n4pCJF6juLSZAH6dql8ihaijCfbc3RokZ/3Bnv6l7Qwez1wTJpE/54pk9GqLQU5TI4uUSmN2h1eyqMUrMZLuYNtde3kHUje5vJgMrPZA4RJuY1SUzEEKZnOflnZrAaOiNHu4kQYIhu3Tp9J9joIW2qmppvGBqJaT7C6/1UuOklZh3d3e5/i1EvcYIZ3gHuEWKnD3GzLmz5+eZ4yhV9RrTAwRCev9g0lTbcwkG40VrghqzzFgTaht3jte+vmK0ulG2SZGlyLhVsQ5TpOXaxJA9ud59ceiIvIOHzzAj5PHpW8guMXUDgUOKNGnPwy3Ea6Ju9DVzWyENzEIch3ghXrEwe1mZfeCyhY9hYhLDQO9+ZcLvVb3fdhwE+AXpIf1omR1FzAAAAABJRU5ErkJggg==) 1x, url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFsAAABZCAMAAABmIKigAAACIlBMVEUAAAAAAAD////////////+/v7////////////////+/v6AgID39/fw8PAAAAD9/f39/f38/PwzMzP8/Pz////7+/sAAABVVVUAAAD4+Pj///////8AAAAAAADf39/6+voAAAAAAAAAAAD9/f339/ckJCQAAAAAAADw8PD+/v78/PwAAAAAAAAAAACnp6dAQEAAAAANDQ0LCwv29vYPDw8AAAAAAADf398qKioXFxcSEhIODg4AAAAAAABZWVkRERELCwsAAAAAAADy8vIQEBAAAAAICAgAAADV1dUgICAAAAAHBwdMTEzw8PAAAAAHBwcAAADx8fEUFBQAAAAJCQkAAADHx8f5+fkAAAAcHBwMDAwJCQkAAAAAAABMTEz8/Pz7+/sAAAAKCgoAAAAAAAAGBgbs7Oynp6fMzMwAAAAAAAAAAADy8vIVFRUAAAAHBwcAAADg4ODu7u7n5+cZGRkMDAwAAAAICAgGBgbj4+MNDQ0AAADd3d2oqKjY2NgHBwcAAADV1dUFBQUAAADT09MAAAAAAAAGBgYAAAAFBQXw8PDQ0NAFBQUAAAAAAAAAAAAJCQna2trR0dEAAAAAAAAAAAAFBQUHBwcHBwdzc3MAAAAFBQUAAAAGBgYAAAAICAjQ0NAAAAAFBQVGRkYGBgYGBgYFBQUEBAQKCgrFxcVISEjn5+f4+Pi4uLjGxsYAAABtbW2wsLCurq49PT0FBQUGBgb9h4g/AAAAtnRSTlMAAWCvv7AgAYD/wAJCEQORoFEFku9BAgMGc99BBQg3MQcKDOEhBwkOiNBhCw0RMQQPExfGERYZgAYLDhIXHC4PGB0iyRAYHiOGCBQkNiITIynKDRIdKHtSBAkWGyAnOfKCEBofJSq9YigVISaHDBolK6SJjQoVGyEskBQqlGGXJiyZMC2bNDEoHjfLnTg1Mi4clpw5NjMvIidHODYwLSQgiTc0Oi4pMTkZfDmx5W+QL0t0dUMzK1W7X5kAAAYVSURBVHgB7NIDoiNBEMbx+Z7qVbLpuGdi27axNu9/kbU5Ws/vAP9GleL4QzgcDocDODk9Oz+5UEB2h4FLfs11cgGCnWVyX+H3zk48dsUJcAvh5Y/5/FDs+B0oL9OBIH8q5AuDrMelVANahL8Q9cUI1vIQIq4lkvw1UV9KQjHdB4SqpTPZHH9d9DJPMLk6JNVAoZgtlfmbKtU8EcF4HjKgJWr1RpO/x1XNm/gbKVpasd7udHv8fa4TDwAFRq4t4+lMvT8YjviHzv2AkbZbjNOT6Wy+WLIOr9b+Fb1rEihMVp31ZrtjXaK+sNQXJynGicm+czhevcZ6RX15PT9PUOPXa+0bh+PNW2yA7zZA9KO4iBcypTuHzd1799mAioTEj9pqPF188HD+aPv4CRvxVEj6QRx49qL9cuFN23rDeNENSZYsCUn2+UtYwkjYksAyRQE5F/SHyNTClRgKQTpp7XYEugyYSbYRkiVby5IloXfWlqZbW1i7Ju2u2fX77TWRuksDx45uk7TzAR69+p3neS/KQkS6cNEwL112o/02phmPl2QUPxcs6YvlypV33Gj/T8YsQ3kIfRCHwmDCeS2/5Eb7XcWHGcZDcmFoQZyuJmt1N1DeswTkp6nxyD0MRlxQ1RvG8sr7jqU/mBDDHGIZAhOGho4ylYud04qOoXyY0lWrGbK/c3x6KDm0EJleba2Z6w6hfFRuxQsRPqBgihR72ScEoxuJ8vlNZ1A+rtTmM7lomPPRFMHiDIWzk2IultaKnziRvrpiauXEhmoJAcyQ4sPIqDk3EW/VrrUdQPl0a7uolRerqsUhmvWStLECUPRGeXnzKlH6s53d9p7WSeilIIcwRZFiz/gCvDht95QlovT1na11U+tkcqVJqNtD7FfDwtV4o1ZfuTFe+uat23fuXqkb3ZmC2Az4aAaYkC1uTemJznL+87HS9+4/6D1cN/eHSAQEoT9D1sYQH7vRPvpibNVfPu49eQo/2YpNi8cWJE8fCivZoFptGQBlbNUgne8PWrGcamUVmXayU1C0Pdlyic75/Fejq77/7Pnu9l6llszoanAByrb7IPEBcCSIhVj6rb2vR0s/3nny4qCyls7oJQi8HwMR0HYykjlLqi4a19o3RksfPi0uGyANTTDrw0Db2XrF+rimmEuc64+AcvPls97u0zwASaxKUzynyCzRf6/j40cLc1KsO/vo0onf+PJBb3f7oD9IQtVzPIeG7dXjdOcEKOpqw6hv3jgRCEgD6+QrXRL57FDaxfngC4BTXnW0vW9OMB/4GqSh6qo9cBSbtdfjXBujJuyz3X3z28snVG1L19Kp1YkIzDLZDo2bS5D2CxCfxqBy5bs3fL0zlE6mqpI4ycEo87palqFwOTQpns10tIOlN6qGNAKQRFWaCgsKZlzePx4P6/MJkYlYd+3vUO5B1YcQ9LVkSpfmAAgeAYTQDKGn6P8Ym7b0FkTG/kYJWCt+5uQ9kGBxzIUBSnq/uPSXyID5oOrafGpVgjQiYA3S7rVlOAZLMDbN9vevpa/DNxb7BkRGGjpk1LpDcMowPqWNRRibP/zZQ7a28xVgDb6GqqFjj4BNzj2MzRycPsVteyZf/vHW494hSBvHrI+/8XQnvpdikWBNDC1+9NPPv/z64PZvsC9UBmk7jfwwjcwZz2lPe8TBupyZ18yVozu95707R+29vjEP0pGm/Y2Ehk2KD4zN+OKgX2y/ePjk6O56sT/owigQbSAsQwBCWrA4KwqHVa1ibrbbv+dNzehmNuzIKDJDPCsJYxPDYQUHeGe2XzfN+vJ+uQtpFI/7NUUWIGxvXFjNXWh0jFlttmZ0WjO2NFRNPJyITvFScBFGSmfjjWS600leTMRzJYsPIIfShD0fI46PlArVmUQjNRPXC/8/9rUj1uSGhbK8FZXO6vpGrqBCTw0gwkR3nk3Wr3B8UIyWVDUqBkFawYQL2DlwloX9TeAnw1YwzAvQU2kXQMh7J0ahgJDlBC4bQn6ZJSTGFRWGpv1+hJCCsMxSDNkhLsShdPthmqUJC47LB1JeAOOhKIZm4LnVJtvcrh4+lix82gfy/71/6fsD3k64pMN/fPUAAAAASUVORK5CYII=) 2x) 9 6, auto !important;
}
.balloon{
  position: fixed;
  top:0;
  left:0;
}

.balloon img {
  width: 130px;
  height: 30px;
  object-fit: cover;
  overflow: hidden;
  border-radius: 40px;

}
</style>
