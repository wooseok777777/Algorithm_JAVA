package com.ssafy.simulation;

import java.util.*;

public class Main_17143_G1_낚시왕_최우석 {
	static int r, c, m;
	static int y, x, s, d, z;
	static int sharkSize;
	static Shark[][] a;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 1, -1 };
	static int fisherIdx = -1;

	static void simulate() {

		while (fisherIdx != c - 1) {
			moveFisher();
			catchShark();
			moveShark();
		}
	}

	static void moveFisher() {
		fisherIdx++;
	}

	static void catchShark() {
		for (int i = 0; i < r; i++) {
			if (a[i][fisherIdx] == null)
				continue;

			sharkSize += a[i][fisherIdx].size;
			a[i][fisherIdx] = null;

			break;
		}
	}

	static void moveShark() {

		PriorityQueue<Shark> pq = new PriorityQueue<>((s1,s2) -> s2.size - s1.size);
		
		for(int i = 0 ;i<r;i++) {
			for(int j = 0 ;j<c;j++) {
				if(a[i][j] == null)continue;
				pq.add(a[i][j]);
			}
		}
		
		a = new Shark[r][c];
		
		while(!pq.isEmpty()) {
			Shark shark = pq.poll();
			shark.move();
			
			int y = shark.y;
			int x = shark.x;
			
			if(a[y][x] != null) continue;
			a[y][x] = shark;
		}
		
	}

	static boolean inside(int y, int x) {
		return 0 <= y && y < r && 0 <= x && x < c;
	}

	static class Shark {
		int speed;
		int direction;
		int size;
		int y;
		int x;

		public Shark(int speed, int direction, int size, int y, int x) {
			super();
			this.speed = speed;
			this.direction = direction;
			this.size = size;
			this.y = y;
			this.x = x;
			
			if(direction == 0 || direction == 1) {
				this.speed %=(r-1)*2;
			}
			if(direction == 2 || direction == 3) {
				this.speed %=(c-1)*2;
			}
			
		}

		private void move() {
		
			
			for (int s = 0; s < speed; s++) {
				y += dy[direction];
				x += dx[direction];
				if (!inside(y, x)) {
					y -= dy[direction];
					x -= dx[direction];
					changeDirection();
					y += dy[direction];
					x += dx[direction];
				}
			}
		}

		private void changeDirection() {
			if (direction == 0) {
				direction = 1;
			} else if (direction == 1) {
				direction = 0;
			} else if (direction == 2) {
				direction = 3;
			} else if (direction == 3) {
				direction = 2;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		m = sc.nextInt();
		a = new Shark[r][c];

		for (int i = 0; i < m; i++) {
			y = sc.nextInt() - 1;
			x = sc.nextInt() - 1;
			s = sc.nextInt();
			d = sc.nextInt() - 1;
			z = sc.nextInt();

			a[y][x] = new Shark(s, d, z, y, x);
		}

		simulate();
		System.out.println(sharkSize);
	}
}
