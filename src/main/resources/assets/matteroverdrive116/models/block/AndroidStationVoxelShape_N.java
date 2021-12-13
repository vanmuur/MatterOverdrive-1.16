Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 4, 16),
Block.makeCuboidShape(2, 4, 2, 14, 7, 14),
Block.makeCuboidShape(0, 7, 0, 16, 9, 16),
Block.makeCuboidShape(1, 4, 12, 2, 7, 13),
Block.makeCuboidShape(1, 4, 10, 2, 7, 11),
Block.makeCuboidShape(1, 4, 8, 2, 7, 9),
Block.makeCuboidShape(3, 4, 1, 4, 7, 2),
Block.makeCuboidShape(5, 4, 1, 6, 7, 2),
Block.makeCuboidShape(7, 4, 1, 8, 7, 2),
Block.makeCuboidShape(14, 4, 3, 15, 7, 4),
Block.makeCuboidShape(14, 4, 5, 15, 7, 6),
Block.makeCuboidShape(14, 4, 7, 15, 7, 8),
Block.makeCuboidShape(12, 4, 14, 13, 7, 15),
Block.makeCuboidShape(10, 4, 14, 11, 7, 15),
Block.makeCuboidShape(8, 4, 14, 9, 7, 15)
).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();