.data
	sim: .asciiz "sim"
	nao: .asciiz "nao"

.text
	main:
		li $v0, 5
		syscall
		move $t0, $v0
		
		li $t1, 0 
		li $t2, 1 
		
	loop:
		bge $t2, $t0, fim
		
		divu $t0, $t2 
		mfhi $t3
		
		beq $t3, $zero, somar_divisor
		
		add $t2, $t2, 1
		j loop
		
	somar_divisor:
		add $t1, $t1, $t2
		
		add $t2, $t2, 1
		j loop
		
	fim:
		beq $t1, $t0, printar_sim
		j printar_nao
		
	printar_sim:
		li $v0, 4
		la $a0, sim
		syscall
		
		li $v0, 10
		syscall
		
	printar_nao:
		li $v0, 4
		la $a0, nao
		syscall
		
		li $v0, 10
		syscall
		